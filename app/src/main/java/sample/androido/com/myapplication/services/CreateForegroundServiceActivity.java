package sample.androido.com.myapplication.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sample.androido.com.myapplication.R;

public class CreateForegroundServiceActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;
    private boolean isReceiverRegistered = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_foreground_service);
        Button startServiceButton = (Button)findViewById(R.id.start_foreground_service_button);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateForegroundServiceActivity.this, MyForeGroundService.class);
                intent.setAction(MyForeGroundService.ACTION_START_FOREGROUND_SERVICE);
                startService(intent);
            }
        });

        Button stopServiceButton = (Button)findViewById(R.id.stop_foreground_service_button);
        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateForegroundServiceActivity.this, MyForeGroundService.class);
                intent.setAction(MyForeGroundService.ACTION_STOP_FOREGROUND_SERVICE);
                startService(intent);
            }
        });

        final TextView display = findViewById(R.id.display);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (intent.getAction()) {
                    case "CALL_CONNECTED":
                        display.setText("call connected");
                        break;
                }

            }
        };
    }


    private void registerReceiver() {

        if(!isReceiverRegistered){
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("CALL_CONNECTED");
            LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,intentFilter);
            isReceiverRegistered = true;
        }
    }
    private void unregisterReceiver() {
        if(broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
            isReceiverRegistered = false;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver();

    }
    @Override
    public void onDestroy() {
        unregisterReceiver();

        super.onDestroy();
    }
}
