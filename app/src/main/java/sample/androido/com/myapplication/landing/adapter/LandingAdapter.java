package sample.androido.com.myapplication.landing.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.landing.pojo.AppNavigation;
import sample.androido.com.myapplication.landing.viewholder.LandingViewHolder;
import sample.androido.com.myapplication.mainpojo.Topic;

public class LandingAdapter extends RecyclerView.Adapter<LandingViewHolder> {
    private Context context;
    private List<Topic> topics;

    public LandingAdapter(Context context, List<Topic> topics) {
        this.context = context;
        this.topics = topics;
    }

    @NonNull
    @Override
    public LandingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.landing_view_holder, viewGroup, false);

        return new LandingViewHolder(context,itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LandingViewHolder landingViewHolder, int position) {
        landingViewHolder.render(topics.get(position));
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }
}
