package com.example.samd_open_ended2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.widget.Toast;

import androidx.core.app.NotificationManagerCompat;

public class Notification extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Notification is clicked", Toast.LENGTH_SHORT).show();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.cancel(1);
    }
}

