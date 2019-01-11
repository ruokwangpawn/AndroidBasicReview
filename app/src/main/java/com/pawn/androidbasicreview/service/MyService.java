package com.pawn.androidbasicreview.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";

    public MyService() {
        Log.e(TAG, "MyService: 构造方法");
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        return new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "onRebind: ");
        super.onRebind(intent);
    }

    private class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public void test() throws RemoteException {
            methodInService();
        }
    }

    public void methodInService() {
        Log.e(TAG, "call methodInService: ");
    }

}
