package com.pawn.androidbasicreview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pawn.androidbasicreview.R;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
