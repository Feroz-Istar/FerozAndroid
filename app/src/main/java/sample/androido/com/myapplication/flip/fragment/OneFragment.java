
package sample.androido.com.myapplication.flip.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.androido.com.myapplication.R;
import sample.androido.com.myapplication.flip.utils.MyData;

public class OneFragment extends Fragment {
    private static final String TAG = "OneFragment";
    public static final String DATA = "SalesData";
    private ViewGroup container;
    private LayoutInflater inflater;
    private MyData myData;
    @BindView(R.id.start_task)
    Button start_task;

    @BindView(R.id.easy_flip)
    EasyFlipView easyFlipView;
    @BindView(R.id.back_task)
    Button back_task;
    BackFragment blankFragment = new BackFragment();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.container = container;
        this.inflater = inflater;
        return initializeView();
    }

    private View initializeView() {

        View view = inflater.inflate(
                R.layout.view_pager_fragment, container, false);
        ButterKnife.bind(this, view);

        if (getArguments() != null) {
            myData = (MyData)getArguments().getSerializable(DATA);



        }

//        final FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//
//        ft.replace(R.id.frame_container, blankFragment, "NewFragmentTag");
//        ft.commit();

        start_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easyFlipView.flipTheView();
            }
        });
        back_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easyFlipView.flipTheView();
            }
        });

            return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// add your code here which executes after the execution of onCreateView() method.

    }
}

