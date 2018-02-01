package arch.vav.com.androidarchitecturecomponentsblueprint.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import arch.vav.com.androidarchitecturecomponentsblueprint.SongsApplication;
import arch.vav.com.androidarchitecturecomponentsblueprint.data.Repository;
import arch.vav.com.androidarchitecturecomponentsblueprint.data.entity.Result;
import arch.vav.com.androidarchitecturecomponentsblueprint.data.entity.SongsData;

/**
 * Created by Vaibhav on 1/31/18.
 */

public class SongsListViewModel extends ViewModel {
    @Inject
    Repository repository;

    LiveData<SongsData> songs;

    public SongsListViewModel(){
        SongsApplication.getSongsApplication().getSongsComponent().inject(this);
    }
    public void init(){
        if(this.songs!=null){
            return;
        }
        songs = repository.getSongsList();
    }

    public LiveData<SongsData> getResult() {
        return songs;
    }
}
