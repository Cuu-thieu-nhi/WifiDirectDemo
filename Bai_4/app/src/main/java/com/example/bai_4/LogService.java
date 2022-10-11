package com.example.bai_4;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.Date;


public class LogService extends Service {

    Handler handler = new Handler(Looper.getMainLooper());
    Runnable runnable;
    int delay = 5000;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                Date currentTime = Calendar.getInstance().getTime();
                Log.d("ANDROID", "5s " + currentTime);
                handler.postDelayed(runnable, delay);

            }
        }, delay);
        sendNotification();
        return START_REDELIVER_INTENT;
    }

    private void sendNotification () {
        Notification notification = new NotificationCompat.Builder (this, MyNotificationChannel.CHANNEL_ID).build();
        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
