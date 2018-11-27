package sample.androido.com.myapplication.topic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.database.MyDatabase;

public class TopicParentActivity extends AppCompatActivity {
    public MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_parent);
        myDatabase = MyDatabase.getInstance(this);
    }
}
