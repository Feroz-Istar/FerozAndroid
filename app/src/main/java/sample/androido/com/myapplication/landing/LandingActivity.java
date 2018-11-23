package sample.androido.com.myapplication.landing;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.database.MyDatabase;
import sample.androido.com.myapplication.landing.adapter.LandingAdapter;
import sample.androido.com.myapplication.landing.pojo.AppNavigation;
import sample.androido.com.myapplication.mainpojo.AppFeature;

public class LandingActivity extends AppCompatActivity {
    private MyDatabase myDatabase;
    String[] PERMISSIONS = {Manifest.permission.INTERNET, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.RECEIVE_BOOT_COMPLETED
            , Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CALL_PHONE, Manifest.permission.PROCESS_OUTGOING_CALLS,
            Manifest.permission.MODIFY_AUDIO_SETTINGS, Manifest.permission.MODIFY_PHONE_STATE,
            Manifest.permission.RECORD_AUDIO, Manifest.permission.CAPTURE_AUDIO_OUTPUT,
            Manifest.permission.CAMERA, Manifest.permission.RECEIVE_SMS,
            Manifest.permission.READ_SMS, Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.READ_SMS
            , Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.RECORD_AUDIO};
    private static final int PERMISSION_REQUEST_CODE = 200;
    private List<AppNavigation> appNavigations = new ArrayList<>();
    @BindView(R.id.recycler_view)
     RecyclerView recyclerView;
    private LandingAdapter landingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);
        myDatabase = MyDatabase.getInstance(this);

        appNavigations.add(new AppNavigation("RSJX TUTORIAL",new Date(),new Date()));
        appNavigations.add(new AppNavigation("ROOM DATABASE",new Date(),new Date()));
        appNavigations.add(new AppNavigation("JOB SCHEDULER",new Date(),new Date()));
        appNavigations.add(new AppNavigation("RETROFIT",new Date(),new Date()));
        appNavigations.add(new AppNavigation("FIREBASE MESSAGING",new Date(),new Date()));




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermissions())
                ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_REQUEST_CODE);
        }

        landingAdapter = new LandingAdapter(this,appNavigations);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(landingAdapter);



    }


    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : PERMISSIONS) {
            result = ContextCompat.checkSelfPermission(getApplicationContext(), p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), PERMISSION_REQUEST_CODE);
            return false;
        }
        return true;
    }
}
