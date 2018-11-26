package com.pawn.androidbasicreview.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;

import com.pawn.androidbasicreview.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("MainActivityHasCreated", true);
        editor.apply();

        boolean isCreated = sharedPreferences.getBoolean("MainActivityHasCreated", false);

        String externalStorageState = Environment.getExternalStorageState();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File dataDirectory = Environment.getDataDirectory();
        File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
        File externalStoragePublicMusicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        File rootDirectory = Environment.getRootDirectory();

        File filesDir = getFilesDir();
        File cacheDir = getCacheDir();
//        File dataDir = getDataDir();
        File codeCacheDir = getCodeCacheDir();
        File obbDir = getObbDir();
        File externalCacheDir = getExternalCacheDir();

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            long freeSpace = Environment.getExternalStorageDirectory().getFreeSpace();
            String fileSize = Formatter.formatFileSize(this, freeSpace);
        }


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("xxx.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            openFileOutput("xxx.txt", MODE_WORLD_READABLE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
