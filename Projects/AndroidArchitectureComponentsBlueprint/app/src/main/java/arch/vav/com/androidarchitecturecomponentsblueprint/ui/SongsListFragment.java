package arch.vav.com.androidarchitecturecomponentsblueprint.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import arch.vav.com.androidarchitecturecomponentsblueprint.R;
import arch.vav.com.androidarchitecturecomponentsblueprint.data.entity.SongsData;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vaibhav on 1/31/18.
 */

public class SongsListFragment extends Fragment{
    @BindView(R.id.song_detail_recyclerview) RecyclerView recyclerView;

    SongsListViewModel songsListViewModel;

    public SongsListFragment(){}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        songsListViewModel = ViewModelProviders.of(this).get(SongsListViewModel.class);
        songsListViewModel.init();
        songsListViewModel.getResult().observe(this, new Observer<SongsData>() {
            @Override
            public void onChanged(@Nullable SongsData songsData) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_list_fragment,container,false);
        ButterKnife.bind(this,view);
        SongsListAdapter adapter = new SongsListAdapter();
        recyclerView.setAdapter(adapter);
        setRetainInstance(true);
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
