package sample.androido.com.myapplication.activitytransion.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PhoneStateReceiver extends BroadcastReceiver {
    private static final String TAG="PhoneStateReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       switch (intent.getAction()){
           case Intent.ACTION_DATE_CHANGED:
               Log.d(TAG,"Intent.ACTION_DATE_CHANGED "+Intent.ACTION_DATE_CHANGED );
               break;
           case Intent.ACTION_SCREEN_OFF:
               Log.d(TAG,"Intent.ACTION_SCREEN_OFF "+Intent.ACTION_SCREEN_OFF );
               break;
           case Intent.ACTION_SCREEN_ON:
               Log.d(TAG,"Intent.ACTION_SCREEN_ON "+Intent.ACTION_SCREEN_ON );
               break;

           case Intent.ACTION_USER_UNLOCKED:
               Log.d(TAG,"Intent.ACTION_USER_UNLOCKED "+Intent.ACTION_USER_UNLOCKED );
               break;
           case Intent.ACTION_PACKAGE_ADDED:
               Log.d(TAG,"Intent.ACTION_PACKAGE_ADDED "+Intent.ACTION_PACKAGE_ADDED );
               break;


               default:
                   Log.d(TAG,"Intent.DEFAULT  "+intent.getAction());

       }

    }
}
