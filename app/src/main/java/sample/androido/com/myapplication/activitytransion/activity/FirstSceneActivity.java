package sample.androido.com.myapplication.activitytransion.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.activitytransion.broadcast.MyWorker;

public class FirstSceneActivity extends AppCompatActivity {
    @BindView(R.id.button6)
    Button button6;
    PeriodicWorkRequest periodicWorkRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_scene);
        ButterKnife.bind(this);
          periodicWorkRequest
                = new PeriodicWorkRequest.Builder(MyWorker.class, 15, TimeUnit.MINUTES)
                .build();
        WorkManager.getInstance().enqueue(periodicWorkRequest);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        },600000);
    }

    @OnClick(R.id.button6)
    public void changeActivityTransition(){
        WorkManager.getInstance().cancelWorkById(periodicWorkRequest.getId());

      /*  Intent intent = new Intent(this, SecondSceneActivity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                // Now we provide a list of Pair items which contain the view we can transitioning
                // from, and the name of the view it is transitioning to, in the launched activity
                new Pair<View, String>(findViewById(R.id.imageView7),
                        SecondSceneActivity.VIEW_NAME_HEADER_IMAGE),
                new Pair<View, String>(findViewById(R.id.textView3),
                        SecondSceneActivity.VIEW_NAME_HEADER_TITLE));
        ActivityCompat.startActivity(this, intent, activityOptions.toBundle());*/
    }



}
