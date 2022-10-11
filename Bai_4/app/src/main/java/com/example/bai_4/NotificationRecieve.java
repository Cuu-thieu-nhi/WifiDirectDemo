package com.example.bai_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationRecieve extends BroadcastReceiver {
    //nhận broadcast từ notification, gọi đến service
    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getStringExtra("action_service");
        Intent i = new Intent(context, LogService.class);
        if (result.equals("Start")) {
            Toast.makeText(context, "Start log", Toast.LENGTH_SHORT).show();
            Thread thread = new Thread() {
                @Override
                public void run() {
                    context.startService(new Intent(i));
                }
            };
            thread.start();
        } else if (result.equals("Stop")) {
            Toast.makeText(context, "Stop log", Toast.LENGTH_SHORT).show();
            context.stopService(i);
        }
    }
}
