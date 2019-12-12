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
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;
import com.jassycliq.playbowcs.databinding.FragmentUserDetailsCalendarBinding;
import com.jassycliq.playbowcs.decorators.BlockWeekendsDecorator;
import com.jassycliq.playbowcs.decorators.EventDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDate;

import java.util.Set;

public class UserDetailsCalendarFragment extends Fragment {

    private FragmentUserDetailsCalendarBinding mBinding;
    private UserDetailsCalendarViewModel userDetailsCalendarViewModel;
    private SharedViewModel sharedViewModel;
    private Set<CalendarDay> receivedDates;
    private Set<CalendarDay> chosenDates;
    private Set<CalendarDay> removedDates;

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

        receivedDates = new ArraySet<CalendarDay>();
        chosenDates = new ArraySet<CalendarDay>();
        removedDates = new ArraySet<CalendarDay>();
        final int eventColor = requireContext().getColor(R.color.colorEvent);

        // Create the observer which updates the UI.
        final Observer<Set<CalendarDay>> chosenDayObserver = calendarDayList -> {
            mBinding.calendarView.addDecorator(new EventDecorator(eventColor, calendarDayList));
            receivedDates.addAll(calendarDayList);
            mBinding.floatingActionButton2.setVisibility(View.VISIBLE);
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
            if (!receivedDates.contains(date)) {
                if (removedDates.size() == 0) {
                    if (selected) {
                        Toast.makeText(requireContext(), "added " + date.toString(), Toast.LENGTH_SHORT).show();
                        chosenDates.add(date);
                    } else {
                        Toast.makeText(requireContext(), "removed " + date.toString(), Toast.LENGTH_SHORT).show();
                        chosenDates.remove(date);
                    }
                } else {
                    Toast.makeText(requireContext(), "Can only cancel dates right now.", Toast.LENGTH_SHORT).show();
                    widget.setDateSelected(date, false);
                }
            } else if (receivedDates.contains(date)){
                if (chosenDates.size() == 0) {
                    if (removedDates.size() != 0) {
                        if (selected) {
                            widget.setDateSelected(date, true);
                            removedDates.add(date);
                            Toast.makeText(requireContext(), "adding " + date + " to removedDate set", Toast.LENGTH_SHORT).show();
                        } else {
                            widget.setDateSelected(date, false);
                            removedDates.remove(date);
                            Toast.makeText(requireContext(), "removing " + date + " from removedDate set", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        widget.setDateSelected(date, true);
                        removedDates.add(date);
                        Toast.makeText(requireContext(), "adding " + date + " to removedDate set", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireContext(), "Can only book dates right now.", Toast.LENGTH_SHORT).show();
                    widget.setDateSelected(date, false);
                }
            }
        });

        mBinding.floatingActionButton2.setOnClickListener(v -> {
            if (!chosenDates.isEmpty()) {
                userDetailsCalendarViewModel.updateCalendar(chosenDates, false);
            } else {
                userDetailsCalendarViewModel.updateCalendar(removedDates, true);
            }
            Toast.makeText(requireContext(), "fab save button", Toast.LENGTH_SHORT).show();
        });

        userDetailsCalendarViewModel.getBookedDates();
    }
}
