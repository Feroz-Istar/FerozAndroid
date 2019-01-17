package sample.androido.com.myapplication.flip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import sample.androido.com.myapplication.R;

public class ThreeFragment extends Fragment {
    private ViewGroup container;
    private LayoutInflater inflater;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.container = container;
        this.inflater = inflater;
        return initializeView();
    }
    private View initializeView() {

        View view = inflater.inflate(
                R.layout.fragment_three, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
