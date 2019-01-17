package sample.androido.com.myapplication.flip.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.customui.customviewpager.CaurosalViewPager;
import sample.androido.com.myapplication.flip.adapter.FlipAdapter;
import sample.androido.com.myapplication.flip.utils.MyData;

public class FlipActivity extends AppCompatActivity {

    @BindView(R.id.mineviewpager)
    CaurosalViewPager mineviewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip);
        ButterKnife.bind(this);
        List<MyData> myDataList = new ArrayList<>();
        Faker faker = new Faker();
        for(int i=0;i<20;i++){
            myDataList.add(new MyData(faker.name().firstName(),faker.name().lastName(),faker.internet().avatar()));
        }

        FlipAdapter flipAdapter = new FlipAdapter(getSupportFragmentManager(),this,myDataList);
        mineviewpager.setAdapter(flipAdapter);



    }
}
