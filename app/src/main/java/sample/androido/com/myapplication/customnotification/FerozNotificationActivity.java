package sample.androido.com.myapplication.customnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.androido.com.myapplication.R;

public class FerozNotificationActivity extends AppCompatActivity {
    public static final String PRIMARY_CHANNEL = "default";
    public static final String SECONDARY_CHANNEL = "secondary_default";
    private BroadcastReceiver broadcastReceiver;
    @BindView(R.id.broadcast)
    Button broadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feroz_notification);
        ButterKnife.bind(this);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                broadcast.setText(intent.getAction());
            }
        };

    }

    @OnClick(R.id.simple_notfication)
    public void createSimpleNotification(){


        Intent intent = new Intent(this, FerozNotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + R.raw.custom_sound);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL)

                .setContentTitle("My notification")
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
    }

    @OnClick(R.id.actionNotification)
    public void sendNotif(){
        Intent intent = new Intent(this, FerozNotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + R.raw.custom_sound);
        Intent buttonIntent = new Intent(getBaseContext(), FerozNotificationActivity.class);
        buttonIntent.putExtra("notificationId", 1234);
        PendingIntent dismissIntent = PendingIntent.getBroadcast(getBaseContext(), 0, buttonIntent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, SECONDARY_CHANNEL)

                .setContentTitle("My notification,kolm,kmo")
                .setContentText("kiikki,Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("klo,k,oMuch longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContentIntent(pendingIntent)
                .setSound(soundUri)
                .setAutoCancel(true);



        mBuilder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent);
        mBuilder.addAction(android.R.drawable.ic_delete, "DISMISS", dismissIntent);

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
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(SECONDARY_CHANNEL  , name, importance);
            channel.setVibrationPattern(new long[]{300, 300, 300});
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

        notificationManager.notify(1234, mBuilder.build());
    }

    @OnClick(R.id.broadcast)
    public void broadcast(){
        Intent intent = new Intent();
        intent.setAction("HELLO");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new
                IntentFilter("HELLO"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
        }
    }
}
