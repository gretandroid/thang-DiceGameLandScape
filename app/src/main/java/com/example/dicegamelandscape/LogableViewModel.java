package com.example.dicegamelandscape;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public abstract class LogableViewModel extends ViewModel implements Logable {
    public LogableViewModel() {
        Log.d(APP + this.getClass().getSimpleName(), "Constructor");
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(APP + this.getClass().getSimpleName(), "onCleared");
    }
}
