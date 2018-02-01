package arch.vav.com.androidarchitecturecomponentsblueprint;

import android.app.Application;

import arch.vav.com.androidarchitecturecomponentsblueprint.di.ApplicationComponent;
import arch.vav.com.androidarchitecturecomponentsblueprint.di.ApplicationModule;
import arch.vav.com.androidarchitecturecomponentsblueprint.di.DaggerApplicationComponent;

/**
 * Created by Vaibhav on 1/31/18.
 */

public class SongsApplication extends Application {
    private static ApplicationComponent component;
    private static SongsApplication application = new SongsApplication();

    @Override
    public void onCreate() {
        super.onCreate();
        getDealsComponent();
    }
    private static Application getSongsApplication(){
        return application;
    }

    public ApplicationComponent getDealsComponent() {
        if(component==null){
            component= DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this)).build();
        }
        return component;
    }
}
