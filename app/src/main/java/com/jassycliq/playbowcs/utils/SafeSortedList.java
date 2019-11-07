package com.jassycliq.playbowcs.utils;

import androidx.recyclerview.widget.SortedList;

import java.util.Collection;

public class SafeSortedList<T> extends SortedList<T> {

    private Callback<T> callback;

    public SafeSortedList(Class<T> klass, Callback<T> callback, int initialCapacity) {
        super(klass, callback, initialCapacity);
        this.callback = callback;
    }

    public SafeSortedList(Class<T> klass, Callback<T> callback) {
        super(klass, callback);
        this.callback = callback;
    }

    @Override
    public int add(T item) {
        for(int i = 0 ; i < size() ; i++) {
            if (callback.areItemsTheSame(get(i), item)) {
                updateItemAt(i, item);
                recalculatePositionOfItemAt(i);
                return indexOf(item);
            }
        }
        return super.add(item);
    }

    @Override
    public void addAll(T[] items, boolean mayModifyInput) {
        for (T item : items)
            add(item);
    }

    @SafeVarargs
    @Override
    public final void addAll(T... items) {
        for (T item : items)
            add(item);
    }

    @Override
    public void addAll(Collection<T> items) {
        for (T item : items)
            add(item);
    }
}
