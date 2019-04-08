package sample.androido.com.myapplication.broadcast;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;

import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.customnotification.FerozNotificationActivity;

public class DateChangeReceiver extends BroadcastReceiver {
    public static final String PRIMARY_CHANNEL = "primaryssyy";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.



    }
}
