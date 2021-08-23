package com.pawn.androidbasicreview.activity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.pawn.androidbasicreview.R;
import com.pawn.androidbasicreview.service.IMyAidlInterface;
import com.pawn.androidbasicreview.service.MyService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private CountDownTimer countDownTimer;

    private int time = 3;

    private IMyAidlInterface iMyAidlInterface;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceConnected: 绑定AIDL成功");
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityManager service = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        int memory = service.getMemoryClass();
        Log.e(TAG, "onCreate:memory ---> " + memory);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        disPlaySystemInfo(metrics);
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        disPlaySystemInfo(metrics);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

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

//        try {
//            openFileOutput("xxx.txt", MODE_WORLD_READABLE);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        countDownTimer = new CountDownTimer(time * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.e(TAG, "onTick: " + millisUntilFinished);
            }

            @Override
            public void onFinish() {
                Log.e(TAG, "onFinish: ");
            }
        };
        countDownTimer.start();

        EditText et = findViewById(R.id.et);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s)) {
                    time = Integer.parseInt(s.toString());
                    countDownTimer.cancel();
                    countDownTimer.start();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        findViewById(R.id.bt_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, MyService.class));
//                myService = new MyService();
            }
        });
        findViewById(R.id.bt_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                myService.test();
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });
        findViewById(R.id.bt_bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.bt_unbind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);
            }
        });
        findViewById(R.id.bt_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    iMyAidlInterface.test();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.bt_scroll_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollEditActivity.class));
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e(TAG, "run: " + isServiceRunning(MainActivity.this, "com.pawn.androidbasicreview.service.MyService"));
                }
            }
        }).start();
    }

    private void disPlaySystemInfo(DisplayMetrics metrics) {
        float density = metrics.density;
        int densityDpi = metrics.densityDpi;
        int heightPixels = metrics.heightPixels;
        int widthPixels = metrics.widthPixels;
        float scaledDensity = metrics.scaledDensity;
        float xdpi = metrics.xdpi;
        float ydpi = metrics.ydpi;
        Log.e(TAG, "disPlaySystemInfo: \ndensity ---> " + density
                + "\ndensityDpi ---> " + densityDpi
                + "\nheightPixels ---> " + heightPixels
                + "\nwidthPixels ---> " + widthPixels
                + "\nscaledDensity ---> " + scaledDensity
                + "\nxdpi ---> " + xdpi
                + "\nydpi ---> " + ydpi
        );
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
        if (iMyAidlInterface != null) {
            try {
                iMyAidlInterface.test();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            Log.e(TAG, "onResume: iMyAidlInterface = null");
        }
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

    @Override
    protected void onNewIntent(Intent intent) {
        Log.e(TAG, "onNewIntent: ");
        super.onNewIntent(intent);
    }

    public boolean isServiceRunning(Context context, String ServiceName) {
        if (TextUtils.isEmpty(ServiceName)) {
            return false;
        }
        ActivityManager myManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> runningService =
                (ArrayList<ActivityManager.RunningServiceInfo>) myManager.getRunningServices(1000);
        for (int i = 0; i < runningService.size(); i++) {
            if (runningService.get(i).service.getClassName().equals(ServiceName)) {
                return true;
            }
        }
        return false;
    }
}
