package com.jassycliq.playbowcs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jassycliq.playbowcs.UserTransactionHistoryBinding;
import com.jassycliq.playbowcs.activity.data.model.UserTransactionHistory;
import com.jassycliq.playbowcs.activity.ui.userDetailsFinancial.UserDetailsFinancialFragment;
import com.jassycliq.playbowcs.utils.SafeSortedList;

import java.util.Comparator;
import java.util.List;

public class UserDetailsFinancialHistoryAdapter extends RecyclerView.Adapter<UserDetailsFinancialFragment.UserViewHolder> {

    private final LayoutInflater mInflater;
    private final Comparator<UserTransactionHistory> mComparator;

    // Provide a suitable constructor (depends on the kind of dataset)
    public UserDetailsFinancialHistoryAdapter(Context context, Comparator<UserTransactionHistory> comparator) {
        mInflater = LayoutInflater.from(context);
        mComparator = comparator;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public UserDetailsFinancialFragment.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final UserTransactionHistoryBinding binding = UserTransactionHistoryBinding.inflate(layoutInflater, parent, false);
        return new UserDetailsFinancialFragment.UserViewHolder(binding);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    @Override
    public void onBindViewHolder(UserDetailsFinancialFragment.UserViewHolder holder, int position) {
        final UserTransactionHistory model = mSortedList.get(position);
        holder.bind(model);
    }

    private final SafeSortedList<UserTransactionHistory> mSortedList = new SafeSortedList<UserTransactionHistory>(UserTransactionHistory.class, new SafeSortedList.Callback<UserTransactionHistory>() {
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
        public int compare(UserTransactionHistory a, UserTransactionHistory b) {
            return mComparator.compare(a, b);
        }

        @Override
        public boolean areContentsTheSame(UserTransactionHistory oldItem, UserTransactionHistory newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(UserTransactionHistory item1, UserTransactionHistory item2) {
            return item1.hashCode() == item2.hashCode();
        }
    });

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mSortedList.size();
    }

    public void add(UserTransactionHistory model) {
        mSortedList.add(model);
    }

    public void remove(UserTransactionHistory model) {
        mSortedList.remove(model);
    }

    public void add(List<UserTransactionHistory> models) {
        mSortedList.addAll(models);
    }

    public void remove(List<UserTransactionHistory> models) {
        mSortedList.beginBatchedUpdates();
        for (UserTransactionHistory model : models) {
            mSortedList.remove(model);
        }
        mSortedList.endBatchedUpdates();
    }

    public void replaceAll(List<UserTransactionHistory> models) {
        mSortedList.beginBatchedUpdates();
        for (int i = mSortedList.size() - 1; i >= 0; i--) {
            final UserTransactionHistory model = mSortedList.get(i);
            if (!models.contains(model)) {
                mSortedList.remove(model);
            }
        }
        mSortedList.addAll(models);
        mSortedList.endBatchedUpdates();
    }
}
