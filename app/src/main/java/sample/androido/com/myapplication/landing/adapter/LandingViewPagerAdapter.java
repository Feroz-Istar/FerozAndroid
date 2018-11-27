package sample.androido.com.myapplication.landing.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import sample.androido.com.myapplication.landing.fragments.DashboardCards;
import sample.androido.com.myapplication.mainpojo.AppFeature;

public class LandingViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<AppFeature>  appFeatures;

    public LandingViewPagerAdapter(FragmentManager fm,List<AppFeature>  appFeatures) {
        super(fm);
        this.appFeatures = appFeatures;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new DashboardCards();
        Bundle bundle = new Bundle();
        bundle.putString(DashboardCards.POSITION,position+"");
        bundle.putSerializable("obj",appFeatures.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return appFeatures.size();
    }
}
