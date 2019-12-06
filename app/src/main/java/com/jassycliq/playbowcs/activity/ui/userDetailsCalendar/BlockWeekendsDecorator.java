package com.jassycliq.playbowcs.activity.ui.userDetailsCalendar;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import org.threeten.bp.DayOfWeek;

/**
 * Block off Saturdays and Sundays
 */
public class BlockWeekendsDecorator implements DayViewDecorator {

    @Override public boolean shouldDecorate(final CalendarDay day) {
        final DayOfWeek weekDay = day.getDate().getDayOfWeek();
        return weekDay == DayOfWeek.SATURDAY || weekDay == DayOfWeek.SUNDAY;
    }

    @Override public void decorate(final DayViewFacade view) {
        view.setDaysDisabled(true);
    }
}
