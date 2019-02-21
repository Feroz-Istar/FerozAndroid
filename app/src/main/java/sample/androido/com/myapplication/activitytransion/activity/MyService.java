package sample.androido.com.myapplication.activitytransion.activity;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import sample.androido.com.myapplication.activitytransion.broadcast.PhoneStateReceiver;

public class MyService extends Service {
    private static final String TAG = "MyService123";
    private PhoneStateReceiver phoneStateReceiver;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
        filter.addAction(Intent.ACTION_DATE_CHANGED);
        filter.addAction(Intent.ACTION_USER_UNLOCKED);
        filter.addAction(Intent.ACTION_USER_BACKGROUND);
        phoneStateReceiver = new PhoneStateReceiver();
        registerReceiver(phoneStateReceiver,filter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        // Unregister screenOnOffReceiver when destroy.
        if(phoneStateReceiver!=null)
        {
            unregisterReceiver(phoneStateReceiver);
            Log.d(TAG, "Service onDestroy: screenOnOffReceiver is unregistered.");
        }
    }
}
