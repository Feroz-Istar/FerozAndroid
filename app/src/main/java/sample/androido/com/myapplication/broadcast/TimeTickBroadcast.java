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
import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Date;

import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.customnotification.FerozNotificationActivity;

public class TimeTickBroadcast extends BroadcastReceiver {
    public static final String PRIMARY_CHANNEL = "primaryyy";
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent nintent = new Intent(context, FerozNotificationActivity.class);
        nintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getPackageName() + "/" + R.raw.custom_sound);

      /*  NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL)

                .setContentTitle("TimeTickBroadcast - "+sdf.format(new Date()))
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setSound(soundUri)
                .setAutoCancel(true);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setSmallIcon(R.drawable.app_icon_white);
            mBuilder.setColor(context.getResources().getColor(R.color.theme_color));
        } else {
            mBuilder.setSmallIcon(R.drawable.app_icon_white);
        }
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getResources().getString(R.string.feroz_channel_name);
            String description =context.getResources(). getString(R.string.feroz_channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(PRIMARY_CHANNEL, name, importance);
            channel.enableLights(true);
            channel.setLightColor(context.getResources().getColor(R.color.theme_color));
            channel.enableVibration(true);
            channel.setDescription(description);
            channel.setSound(soundUri, new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build());
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this



            NotificationManager notificationManager1 = context.getSystemService(NotificationManager.class);
            notificationManager1.createNotificationChannel(channel);


        }
// notificationId is a unique int for each notification that you must define
        notificationManager.notify(1232333, mBuilder.build());*/

    }
}
