package com.example.dicegamelandscape;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public abstract class LogableActivity extends AppCompatActivity implements Logable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(APP + this.getClass().getSimpleName(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(APP + this.getClass().getSimpleName(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(APP + this.getClass().getSimpleName(), "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(APP + this.getClass().getSimpleName(), "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(APP + this.getClass().getSimpleName(), "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(APP + this.getClass().getSimpleName(), "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(APP + this.getClass().getSimpleName(), "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(APP + this.getClass().getSimpleName(), "onSaveInstanceState");
    }
}
