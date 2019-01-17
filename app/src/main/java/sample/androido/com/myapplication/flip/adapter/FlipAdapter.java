package sample.androido.com.myapplication.flip.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import sample.androido.com.myapplication.flip.fragment.OneFragment;
import sample.androido.com.myapplication.flip.utils.MyData;

public class FlipAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private List<MyData> myDataList;

    public FlipAdapter(FragmentManager fm, Context context, List<MyData> myDataList) {
        super(fm);
        this.context = context;
        this.myDataList = myDataList;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(OneFragment.DATA, myDataList.get(i));
        Fragment fragment = new OneFragment();


        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
       // super.destroyItem(ViewGroup container, int position, Object object);
    }
}
