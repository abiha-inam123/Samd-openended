package com.example.samd_open_ended2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.RemoteViews;
import static com.example.samd_open_ended2.App.CHANNEL_ID;


public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
    }

    public void showNotification(View v) {

        RemoteViews collapsedView = new RemoteViews(getPackageName(),
                R.layout.collapsed);
        RemoteViews expandedView = new RemoteViews(getPackageName(),
                R.layout.expanded);

        Intent clickIntent = new Intent(this, Notification.class);
        PendingIntent clickPendingIntent = PendingIntent.getBroadcast(this,
                0, clickIntent, 0);

        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World!");

        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.img_2);
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent);

        android.app.Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                .build();

        notificationManager.notify(1, notification);
    }
}