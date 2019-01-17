package sample.androido.com.myapplication.flip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sample.androido.com.myapplication.R;

public class TwoFragment extends Fragment {
    private ViewGroup container;
    private LayoutInflater inflater;

    @BindView(R.id.go_to_three)
    Button go_to_three;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.container = container;
        this.inflater = inflater;
        return initializeView();
    }
    private View initializeView() {

        View view = inflater.inflate(
                R.layout.fragment_two, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.go_to_three)
    public void clickhree(){
        final FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(R.id.frame_container, new ThreeFragment(), "NewFragmentTag");
        ft.commit();
    }
}
