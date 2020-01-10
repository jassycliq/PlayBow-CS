package com.jassycliq.playbowcs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jassycliq.playbowcs.UserProfile;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.activity.ui.ownership.OwnershipFragment;
import com.jassycliq.playbowcs.utils.SafeSortedList;

import java.util.Comparator;
import java.util.List;

public class OwnershipAdapter extends RecyclerView.Adapter<OwnershipFragment.UserViewHolder> {

    private final SafeSortedList<OwnershipModel.UserProfile> mSortedList = new SafeSortedList<>(OwnershipModel.UserProfile.class, new SafeSortedList.Callback<OwnershipModel.UserProfile>() {
        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count) {
            notifyItemRangeChanged(position, count);
        }

        @Override
        public int compare(OwnershipModel.UserProfile a, OwnershipModel.UserProfile b) {
            return mComparator.compare(a, b);
        }

        @Override
        public boolean areContentsTheSame(OwnershipModel.UserProfile oldItem, OwnershipModel.UserProfile newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(OwnershipModel.UserProfile item1, OwnershipModel.UserProfile item2) {
            return item1.hashCode() == item2.hashCode();
        }
    });

    private final LayoutInflater mInflater;
    private final Comparator<OwnershipModel.UserProfile> mComparator;

    // Provide a suitable constructor (depends on the kind of dataset)
    public OwnershipAdapter(Context context, Comparator<OwnershipModel.UserProfile> comparator) {
        mInflater = LayoutInflater.from(context);
        mComparator = comparator;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public OwnershipFragment.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final UserProfile binding = UserProfile.inflate(layoutInflater, parent, false);
        return new OwnershipFragment.UserViewHolder(binding);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    @Override
    public void onBindViewHolder(OwnershipFragment.UserViewHolder holder, int position) {
        final OwnershipModel.UserProfile model = mSortedList.get(position);
        holder.bind(model);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mSortedList.size();
    }

    public void add(OwnershipModel.UserProfile model) {
        mSortedList.add(model);
    }

    public void remove(OwnershipModel.UserProfile model) {
        mSortedList.remove(model);
    }

    public void add(List<OwnershipModel.UserProfile> models) {
        mSortedList.addAll(models);
    }

    public void remove(List<OwnershipModel.UserProfile> models) {
        mSortedList.beginBatchedUpdates();
        for (OwnershipModel.UserProfile model : models) {
            mSortedList.remove(model);
        }
        mSortedList.endBatchedUpdates();
    }

    public void replaceAll(List<OwnershipModel.UserProfile> models) {
        mSortedList.beginBatchedUpdates();
        for (int i = mSortedList.size() - 1; i >= 0; i--) {
            final OwnershipModel.UserProfile model = mSortedList.get(i);
            if (!models.contains(model)) {
                mSortedList.remove(model);
            }
        }
        mSortedList.addAll(models);
        mSortedList.endBatchedUpdates();
    }
}
