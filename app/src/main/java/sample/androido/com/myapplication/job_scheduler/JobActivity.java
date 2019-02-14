package sample.androido.com.myapplication.job_scheduler;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.androido.com.myapplication.R;

public class JobActivity extends AppCompatActivity {
    @BindView(R.id.cancel_job)
    Button cancel_job;

    @BindView(R.id.start_job)
    Button start_job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.start_job)
    public void startJob(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            MyJobScheduler.scheduleTasks(this);
        }
    }

    @OnClick(R.id.cancel_job)
    public void canceljob(){

    }
}
