package com.jassycliq.playbowcs.activity.ui.userDetailsCalendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;
import com.jassycliq.playbowcs.databinding.FragmentUserDetailsCalendarBinding;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDate;

import java.util.Set;

public class UserDetailsCalendarFragment extends Fragment {

    private FragmentUserDetailsCalendarBinding mBinding;
    private UserDetailsCalendarViewModel userDetailsCalendarViewModel;
    private SharedViewModel sharedViewModel;
    private Set<CalendarDay> chosenDates;
    private OwnershipModel.UserProfile userProfile;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_details_calendar, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AndroidThreeTen.init(requireActivity());

        userDetailsCalendarViewModel = ViewModelProviders.of(this).get(UserDetailsCalendarViewModel.class);
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        userProfile = sharedViewModel.getSelected().getValue();

        chosenDates = new ArraySet<CalendarDay>();
        final int eventColor = requireContext().getColor(R.color.colorEvent);

        // Create the observer which updates the UI.
        final Observer<Set<CalendarDay>> chosenDayObserver = calendarDayList -> {
            mBinding.calendarView.addDecorator(new EventDecorator(eventColor, calendarDayList));
            chosenDates.addAll(calendarDayList);
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        userDetailsCalendarViewModel.getChosenDates().observe(this, chosenDayObserver);

        LocalDate minimumDate = LocalDate.now();
        LocalDate maximumDate = LocalDate.now().plusMonths(3);

        mBinding.calendarView.addDecorators(
                new BlockWeekendsDecorator()
        );

        mBinding.calendarView.state()
                .edit()
                .setMinimumDate(minimumDate)
                .setMaximumDate(maximumDate)
                .commit();

        mBinding.calendarView.getLeftArrow().setTint(requireActivity().getColor(R.color.onSurface));
        mBinding.calendarView.getRightArrow().setTint(requireActivity().getColor(R.color.onSurface));
        mBinding.calendarView.setDateTextAppearance(requireActivity().getColor(R.color.onSurface));

        mBinding.calendarView.setOnDateChangedListener((widget, date, selected) -> {
            if (!chosenDates.contains(date)) {
                Toast.makeText(requireContext(), "added " + date.toString(), Toast.LENGTH_SHORT).show();
                chosenDates.add(date);
            } else {
                Toast.makeText(requireContext(), "removed " + date.toString(), Toast.LENGTH_SHORT).show();
                chosenDates.remove(date);
            }
        });

        userDetailsCalendarViewModel.getBookedDates();
    }
}
