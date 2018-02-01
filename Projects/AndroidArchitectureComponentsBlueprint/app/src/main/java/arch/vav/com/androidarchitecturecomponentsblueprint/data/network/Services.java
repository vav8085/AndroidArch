package arch.vav.com.androidarchitecturecomponentsblueprint.data.network;

import android.content.Context;

import javax.inject.Inject;

import arch.vav.com.androidarchitecturecomponentsblueprint.data.entity.Result;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Vaibhav on 1/31/18.
 */

public class Services {

    private static final String APIPATH = "https://s3.amazonaws.com/vaibhavtestbucket/";
    private static final String API = "document.json";
    private static final String CACHING = "Cache-Control: no-cache";

    private static DealsService dealsService=null;
    public static DealsService getDealsApi() {
        if(dealsService==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIPATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            dealsService = retrofit.create(DealsService.class);
        }
        return dealsService;
    }

    public interface DealsService {
        @Headers(CACHING)
        @GET(API)
        Call<Result> getDeals();
    }
}
