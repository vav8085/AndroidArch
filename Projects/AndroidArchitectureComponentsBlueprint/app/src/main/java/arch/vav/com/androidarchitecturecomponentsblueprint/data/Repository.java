package arch.vav.com.androidarchitecturecomponentsblueprint.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import arch.vav.com.androidarchitecturecomponentsblueprint.data.entity.Result;
import arch.vav.com.androidarchitecturecomponentsblueprint.data.entity.SongsData;
import arch.vav.com.androidarchitecturecomponentsblueprint.data.network.Services;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vaibhav on 1/31/18.
 */

public class Repository {

    public LiveData<SongsData> getSongsList(){
        final MutableLiveData<SongsData> data = new MutableLiveData<>();
        Services.getSongs().getSongs().enqueue(new Callback<SongsData>() {
            @Override
            public void onResponse(Call<SongsData> call, Response<SongsData> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SongsData> call, Throwable t) {

            }
        });
        return data;
    }
}
