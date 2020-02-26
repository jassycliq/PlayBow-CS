package com.jassycliq.playbowcs.activity.ui.userDetailsFinancial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import  	androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.UserTransactionHistoryBinding;
import com.jassycliq.playbowcs.activity.data.model.UserTransactionHistory;
import com.jassycliq.playbowcs.databinding.FragmentUserDetailsFinancialBinding;

import org.jetbrains.annotations.NotNull;

public class UserDetailsFinancialFragment extends Fragment {
    private FragmentUserDetailsFinancialBinding mBinding;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private UserDetailsFinancialViewModel financialHistoryViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_details_financial, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AndroidThreeTen.init(requireActivity());

        recyclerView = mBinding.fragmentUserDetailsFinancialRecyclerView;
        swipeRefreshLayout = mBinding.fragmentUserDetailsFinancialSwipeRefreshLayout;

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        financialHistoryViewModel = new ViewModelProvider(this).get(UserDetailsFinancialViewModel.class);

        recyclerView.setAdapter(financialHistoryViewModel.getAdapter());

        swipeRefreshLayout.setOnRefreshListener(() -> financialHistoryViewModel.getUserDetailsFinancialHistory(swipeRefreshLayout));

        if (financialHistoryViewModel.getmModels() == null) {
            financialHistoryViewModel.getUserDetailsFinancialHistory(swipeRefreshLayout);
        }
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private UserTransactionHistoryBinding mBinding;

        public UserViewHolder(UserTransactionHistoryBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(UserTransactionHistory item) {
            mBinding.setModel(item);
//            mBinding.homeActivityOnClickView.setOnClickListener(v -> {
//                sharedViewModel.select(item);
//            });
            mBinding.executePendingBindings();
        }
    }

}
