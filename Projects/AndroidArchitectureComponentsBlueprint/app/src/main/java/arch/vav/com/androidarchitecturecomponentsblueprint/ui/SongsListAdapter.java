package arch.vav.com.androidarchitecturecomponentsblueprint.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

import arch.vav.com.androidarchitecturecomponentsblueprint.R;
import butterknife.ButterKnife;

/**
 * Created by Vaibhav on 1/31/18.
 */

public class SongsListAdapter extends RecyclerView.Adapter<SongsListAdapter.SongsViewHolder> {
    private SongsViewHolder viewHolder;
    @Override
    public SongsListAdapter.SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_row,parent,false);
        viewHolder = new SongsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SongsListAdapter.SongsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

     class SongsViewHolder extends RecyclerView.ViewHolder {
        public SongsViewHolder(View v){
            super(v);
            ButterKnife.bind(this,v);

        }
    }
}
