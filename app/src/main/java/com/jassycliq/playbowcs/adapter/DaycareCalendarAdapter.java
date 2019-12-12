package com.jassycliq.playbowcs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jassycliq.playbowcs.DogProfileBinding;
import com.jassycliq.playbowcs.activity.data.model.DaycareCalendarDogProfile;
import com.jassycliq.playbowcs.activity.ui.daycareCalendar.DaycareCalendarFragment;
import com.jassycliq.playbowcs.utils.SafeSortedList;

import java.util.Comparator;
import java.util.List;

public class DaycareCalendarAdapter extends RecyclerView.Adapter<DaycareCalendarFragment.DogViewHolder> {
    private final SafeSortedList<DaycareCalendarDogProfile> mSortedList = new SafeSortedList<>(DaycareCalendarDogProfile.class, new SafeSortedList.Callback<DaycareCalendarDogProfile>() {
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
        public int compare(DaycareCalendarDogProfile a, DaycareCalendarDogProfile b) {
            return mComparator.compare(a, b);
        }

        @Override
        public boolean areContentsTheSame(DaycareCalendarDogProfile oldItem, DaycareCalendarDogProfile newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(DaycareCalendarDogProfile item1, DaycareCalendarDogProfile item2) {
            return item1.hashCode() == item2.hashCode();
        }
    });

    private final LayoutInflater mInflater;
    private final Comparator<DaycareCalendarDogProfile> mComparator;

    // Provide a suitable constructor (depends on the kind of dataset)
    public DaycareCalendarAdapter(Context context, Comparator<DaycareCalendarDogProfile> comparator) {
        mInflater = LayoutInflater.from(context);
        mComparator = comparator;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public DaycareCalendarFragment.DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final DogProfileBinding binding = DogProfileBinding.inflate(layoutInflater, parent, false);
        return new DaycareCalendarFragment.DogViewHolder(binding);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    @Override
    public void onBindViewHolder(DaycareCalendarFragment.DogViewHolder holder, int position) {
        final DaycareCalendarDogProfile model = mSortedList.get(position);
        holder.bind(model);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mSortedList.size();
    }

    public void add(DaycareCalendarDogProfile model) {
        mSortedList.add(model);
    }

    public void remove(DaycareCalendarDogProfile model) {
        mSortedList.remove(model);
    }

    public void add(List<DaycareCalendarDogProfile> models) {
        mSortedList.addAll(models);
    }

    public void remove(List<DaycareCalendarDogProfile> models) {
        mSortedList.beginBatchedUpdates();
        for (DaycareCalendarDogProfile model : models) {
            mSortedList.remove(model);
        }
        mSortedList.endBatchedUpdates();
    }

    public void replaceAll(List<DaycareCalendarDogProfile> models) {
        mSortedList.beginBatchedUpdates();
        for (int i = mSortedList.size() - 1; i >= 0; i--) {
            final DaycareCalendarDogProfile model = mSortedList.get(i);
            if (!models.contains(model)) {
                mSortedList.remove(model);
            }
        }
        mSortedList.addAll(models);
        mSortedList.endBatchedUpdates();
    }
}
