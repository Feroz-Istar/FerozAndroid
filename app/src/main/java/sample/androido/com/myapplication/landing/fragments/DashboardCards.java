package sample.androido.com.myapplication.landing.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.landing.LandingActivity;
import sample.androido.com.myapplication.mainpojo.AppFeature;

public class DashboardCards extends Fragment {
    public static final String POSITION = "position";

    private Context context;
    private ViewGroup container;
    private LayoutInflater inflater;


    @BindView(R.id.imageView4)
     ImageView imageView;

    @BindView(R.id.textView4)
    TextView textView;

    @BindView(R.id.cardView2)
    CardView cardView;

    private AppFeature appFeature;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.container = container;
        this.inflater = inflater;
        return initializeView();
    }

    public View initializeView() {
        final View view;
        final int orientation = getResources().getConfiguration().orientation;
        context = getContext();
        view = inflater.inflate(
                R.layout.dashboard_card, container, false);
        ButterKnife.bind(this, view);
        appFeature = (AppFeature) getArguments().getSerializable("obj");
        Picasso.get().load(appFeature.getImage_url()).into(imageView);

        textView.setText(appFeature.getName());
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {

        } else {

        }
        return view;
    }

    @OnClick(R.id.cardView2)
    public void cardClick(){
        Intent intent = new Intent(getContext(),LandingActivity.class);
        intent.putExtra("feature_id",appFeature.getId());
        startActivity(intent);
        ((Activity)getContext()).finish();
    }

}
