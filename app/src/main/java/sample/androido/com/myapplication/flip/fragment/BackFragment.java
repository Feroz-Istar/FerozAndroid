package sample.androido.com.myapplication.flip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.androido.com.myapplication.R;

public class BackFragment extends Fragment {
    private static final String TAG = "BackFragment";

    private ViewGroup container;
    private LayoutInflater inflater;
    @BindView(R.id.button)
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.container = container;
        this.inflater = inflater;
        return initializeView();
    }

    private View initializeView() {

        View view = inflater.inflate(
                R.layout.six_button, container, false);
        ButterKnife.bind(this, view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.frame_container, new TwoFragment(), "NewFragmentTag");
                ft.commit();
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// add your code here which executes after the execution of onCreateView() method.
        if(getParentFragment() instanceof OneFragment){
            Log.d(TAG,"tis iitiiti");
            Button button = view.findViewById(R.id.back_task);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((OneFragment) getParentFragment()).easyFlipView.flipTheView();
                }
            });
        }else{
            Log.d(TAG,"No ooooooooooooooooooooooo");

        }
    }

}
