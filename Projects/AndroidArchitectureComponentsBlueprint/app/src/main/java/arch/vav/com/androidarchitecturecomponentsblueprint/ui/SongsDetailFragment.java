package arch.vav.com.androidarchitecturecomponentsblueprint.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import arch.vav.com.androidarchitecturecomponentsblueprint.R;
import butterknife.ButterKnife;

/**
 * Created by Vaibhav on 1/31/18.
 */

public class SongsDetailFragment extends Fragment{

    public SongsDetailFragment(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_details_fragment,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
