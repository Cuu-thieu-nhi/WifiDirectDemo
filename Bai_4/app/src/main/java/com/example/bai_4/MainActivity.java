package com.example.bai_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotifi();
            }
        });
        sendNotifi();
    }

    private void sendNotifi() {
        //Tạo thông báo có 2 nút start stop
        Intent broadcastIntent1 = new Intent(this, NotificationRecieve.class);
        broadcastIntent1.setAction("START");
        broadcastIntent1.putExtra("action_service", "Start");
        PendingIntent actionIntent1 = PendingIntent.getBroadcast(this, 0, broadcastIntent1, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent broadcastIntent2 = new Intent(this, NotificationRecieve.class);
        broadcastIntent1.setAction("STOP");
        broadcastIntent2.putExtra("action_service", "Stop");
        PendingIntent actionIntent2 = PendingIntent.getBroadcast(this, 0, broadcastIntent2, 0);

        Intent activityIntent = new Intent(this, MainActivity.class);
        activityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, activityIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, MyNotificationChannel.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_settings_24)
                .setContentTitle("Logcat service")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .addAction(1, "Start", actionIntent1)
                .addAction(2, "Stop", actionIntent2)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .setColor(Color.BLUE)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(3, notification);
        }
    }
}