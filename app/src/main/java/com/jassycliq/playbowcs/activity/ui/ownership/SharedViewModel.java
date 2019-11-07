package com.jassycliq.playbowcs.activity.ui.ownership;

import android.util.Log;

import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jassycliq.playbowcs.model.OwnershipModel;

public class SharedViewModel extends ViewModel implements Observable {
    private final MutableLiveData<OwnershipModel.UserProfile> selected = new MutableLiveData<OwnershipModel.UserProfile>();
    private PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

    public void select(OwnershipModel.UserProfile userProfile) {
        Log.e("liveData changed: ", String.valueOf(true));
        selected.setValue(userProfile);
    }

    public LiveData<OwnershipModel.UserProfile> getSelected() {
        return selected;
    }

    /**
     * Adds a callback to listen for changes to the Observable.
     *
     * @param callback The callback to start listening.
     */
    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    /**
     * Removes a callback from those listening for changes.
     *
     * @param callback The callback that should stop listening.
     */
    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }

    /**
     * Notifies observers that all properties of this instance have changed.
     */
    void notifyChange() {
        callbacks.notifyCallbacks(this, 0, null);
    }

    /**
     * Notifies observers that a specific property has changed. The getter for the
     * property that changes should be marked with the @Bindable annotation to
     * generate a field in the BR class to be used as the fieldId parameter.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    void notifyPropertyChanged(int fieldId) {
        callbacks.notifyCallbacks(this, fieldId, null);
    }

}

