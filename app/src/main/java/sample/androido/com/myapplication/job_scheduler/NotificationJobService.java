package sample.androido.com.myapplication.job_scheduler;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.customnotification.FerozNotificationActivity;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class NotificationJobService extends JobService {
    public static final String TAG = "NotificationJobService";

    public static final String PRIMARY_CHANNEL = "default";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG,"Starting job service ...");
        createSimpleNotification();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG,"Stopping job service ...");

        return true;
    }


    public void createSimpleNotification(){

        Log.d(TAG,"creating notification ...");

        Intent intent = new Intent(this, FerozNotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + R.raw.custom_sound);
        Date date = new Date();
        String time ="NA";
        try{
            time = sdf.format(date);
        }catch (Exception e){

        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL)

                .setContentTitle("My "+time)
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setSound(soundUri)
                .setAutoCancel(true);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setSmallIcon(R.drawable.app_icon_white);
            mBuilder.setColor(getResources().getColor(R.color.theme_color));
        } else {
            mBuilder.setSmallIcon(R.drawable.app_icon_white);
        }
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.feroz_channel_name);
            String description = getString(R.string.feroz_channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(PRIMARY_CHANNEL, name, importance);
            channel.enableLights(true);
            channel.setLightColor(getResources().getColor(R.color.theme_color));
            channel.enableVibration(true);
            channel.setDescription(description);
            channel.setSound(soundUri, new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build());
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this



            NotificationManager notificationManager1 = getSystemService(NotificationManager.class);
            notificationManager1.createNotificationChannel(channel);


        }
// notificationId is a unique int for each notification that you must define
        notificationManager.notify(123, mBuilder.build());
        Log.d(TAG," notification sent ...");

    }
}
