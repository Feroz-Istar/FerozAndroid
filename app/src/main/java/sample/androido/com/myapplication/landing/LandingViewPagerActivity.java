package sample.androido.com.myapplication.landing;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.customui.customviewpager.CaurosalViewPager;
import sample.androido.com.myapplication.database.MyDatabase;
import sample.androido.com.myapplication.dataprovider.AppData;
import sample.androido.com.myapplication.landing.adapter.LandingViewPagerAdapter;

public class LandingViewPagerActivity extends AppCompatActivity {
    @BindView(R.id.viewpager)
     CaurosalViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_view_pager);
        ButterKnife.bind(this);
        List<String> nos = new ArrayList<>();
        nos.add(1+"");
        nos.add(2+"");
        nos.add(3+"");
        nos.add(4+"");
        nos.add(5+"");
        nos.add(6+"");
        nos.add(7+"");
        nos.add(8+"");
        nos.add(9+"");
        nos.add(10+"");
        MyDatabase myDatabase = MyDatabase.getInstance(this);

        LandingViewPagerAdapter landingViewPagerAdapter = new LandingViewPagerAdapter(getSupportFragmentManager(),myDatabase.getAppFeatureDao().getAll());
        viewpager.setAdapter(landingViewPagerAdapter);


    }



}
