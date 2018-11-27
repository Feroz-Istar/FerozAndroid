package sample.androido.com.myapplication.landing.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.landing.pojo.AppNavigation;
import sample.androido.com.myapplication.mainpojo.Topic;

public class LandingViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.appnaviagtion)
     TextView appnav;
    @BindView(R.id.go)
     Button go;
    @BindView(R.id.card_view)
    CardView card_view;
    private Context context;
    public LandingViewHolder(Context context,@NonNull View itemView) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);

    }

    public  void render(Topic topic){
        appnav.setText(topic.getName());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            card_view.setCardBackgroundColor(context.getColor(R.color.red_400));
        }
    }
}
