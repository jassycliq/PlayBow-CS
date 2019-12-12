package com.jassycliq.playbowcs.activity.ui.daycareCalendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.jassycliq.playbowcs.DogProfileBinding;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.data.model.DaycareCalendarDogProfile;
import com.jassycliq.playbowcs.databinding.FragmentDaycareCalendarBinding;
import com.jassycliq.playbowcs.decorators.BlockWeekendsDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDate;

import java.util.List;

public class DaycareCalendarFragment extends Fragment {
    private DaycareCalendarViewModel daycareCalendarViewModel;
    private FragmentDaycareCalendarBinding mBinding;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MaterialCalendarView calendarView;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_daycare_calendar, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AndroidThreeTen.init(requireActivity());

        recyclerView = mBinding.fragmentDaycareCalendarRecyclerView;
        swipeRefreshLayout = mBinding.fragmentDaycareCalendarSwipeRefresh;
        calendarView = mBinding.fragmentDaycareCalendarCalendarView;

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        daycareCalendarViewModel = ViewModelProviders.of(this).get(DaycareCalendarViewModel.class);

        recyclerView.setAdapter(daycareCalendarViewModel.getmAdapter());

        // Create the observer which updates the UI.
        final Observer<DaycareCalendarResult> daycareCalendarResultObserver = (DaycareCalendarResult daycareCalendarResult) -> {
            if (daycareCalendarResult.getSuccess() != null) {
                mBinding.fragmentDaycareCalendarTextview.setText(getString(R.string.fragment_daycare_calendar_textview, daycareCalendarResult.getSuccess().getData().getDogProfile().size()));
            }

            if (daycareCalendarResult.getFailure() != null) {

            }
        };

        final Observer<List<DaycareCalendarDogProfile>> dogListObserver = (List<DaycareCalendarDogProfile> dogList) -> {
            swipeRefreshLayout.setRefreshing(false);
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        daycareCalendarViewModel.getCalendarResponse().observe(this, daycareCalendarResultObserver);
        daycareCalendarViewModel.getDogProfileList().observe(this, dogListObserver);

        LocalDate minimumDate = LocalDate.now();
        LocalDate maximumDate = LocalDate.now().plusMonths(3);

        calendarView.addDecorators(
                new BlockWeekendsDecorator()
        );

        calendarView.state()
                .edit()
                .setMinimumDate(minimumDate)
                .setMaximumDate(maximumDate)
                .commit();

        calendarView.getLeftArrow().setTint(requireActivity().getColor(R.color.onSurface));
        calendarView.getRightArrow().setTint(requireActivity().getColor(R.color.onSurface));
        calendarView.setDateTextAppearance(requireActivity().getColor(R.color.onSurface));

        calendarView.setOnDateChangedListener((widget, date, selected) -> {
            daycareCalendarViewModel.getDogsAttending(date);
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (calendarView.getSelectedDate() != null) {
                daycareCalendarViewModel.getDogsAttending(calendarView.getSelectedDate());
            } else {
                Toast.makeText(requireContext(), "Please choose a date in order to refresh", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    public static class DogViewHolder extends RecyclerView.ViewHolder {
        private DogProfileBinding mBinding;

        public DogViewHolder(DogProfileBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(DaycareCalendarDogProfile item) {
            mBinding.setModel(item);
//            mBinding.homeActivityOnClickView.setOnClickListener(v -> {
//                sharedViewModel.select(item);
//                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_userProfileFragment);
//            });
            mBinding.executePendingBindings();
        }
    }
}
