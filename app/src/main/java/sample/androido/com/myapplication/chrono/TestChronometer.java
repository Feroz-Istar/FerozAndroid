package sample.androido.com.myapplication.chrono;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.androido.com.myapplication.R;

public class TestChronometer extends AppCompatActivity {
    @BindView(R.id.mychrono)
    Chronometer mychrono;
    @BindView(R.id.display)
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_chronometer);
        ButterKnife.bind(this);
        mychrono.setBase(SystemClock.elapsedRealtime());
        mychrono.start();


    }

    @OnClick(R.id.button_click)
    public void button_click(){
        long elapsedMillis = SystemClock.elapsedRealtime() - mychrono.getBase();
        display.setText(SystemClock.elapsedRealtime() +"");
    }

    @OnClick(R.id.reset_chrono)
    public void reset_chrono(){
        mychrono.setBase(SystemClock.elapsedRealtime()-10000);
        mychrono.start();

    }

}
