package arch.vav.com.androidarchitecturecomponentsblueprint.ui;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import arch.vav.com.androidarchitecturecomponentsblueprint.data.entity.Result;

/**
 * Created by Vaibhav on 1/31/18.
 */

public class SongsListViewModel extends ViewModel {

    MutableLiveData<Result> result;

    SongsListViewModel(){
        result = new MutableLiveData<>();
    }

    public MutableLiveData<Result> getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result.postValue(result);
    }
}
