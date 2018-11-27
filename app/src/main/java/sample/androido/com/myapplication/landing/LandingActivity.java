package sample.androido.com.myapplication.landing;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.database.MyDatabase;
import sample.androido.com.myapplication.dataprovider.AppData;
import sample.androido.com.myapplication.dataprovider.FeatureNameConstant;
import sample.androido.com.myapplication.landing.adapter.LandingAdapter;
import sample.androido.com.myapplication.landing.pojo.AppNavigation;
import sample.androido.com.myapplication.mainpojo.AppFeature;
import sample.androido.com.myapplication.mainpojo.Topic;

public class LandingActivity extends AppCompatActivity {
    private MyDatabase myDatabase;

    @BindView(R.id.recycler_view)
     RecyclerView recyclerView;
    private LandingAdapter landingAdapter;
    private List<Topic> topics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        myDatabase= MyDatabase.getInstance(this);
        if(getIntent() != null) {
            int feature_id = getIntent().getIntExtra("feature_id",-1);
            if(feature_id != -1) {
                topics = myDatabase.getTopicDao().getTopicByFeautreId(feature_id);
            }

        }







        landingAdapter = new LandingAdapter(this,topics);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(landingAdapter);



    }


    @Override
    public void onBackPressed(){
        startActivity(new Intent(LandingActivity.this,LandingViewPagerActivity.class));
        finish();
    }





}

