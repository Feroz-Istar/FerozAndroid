package sample.androido.com.myapplication.topic.rsjx.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.reactivestreams.Subscriber;

import io.reactivex.*;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.topic.TopicParentActivity;
import io.reactivex.Observable;
public class RsJxActivity extends TopicParentActivity {

    private static final String TAG ="RsJxActivity" ;
    @BindView(R.id.text)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_jx);
        ButterKnife.bind(this);


    }


}
