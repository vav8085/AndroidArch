package arch.vav.com.androidarchitecturecomponentsblueprint.di;

import android.content.Context;

import javax.inject.Singleton;

import arch.vav.com.androidarchitecturecomponentsblueprint.SongsApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Vaibhav on 1/31/18.
 */

@Module
public class ApplicationModule {
    private final SongsApplication application;

    public ApplicationModule(SongsApplication application) {
        this.application = application;
    }
    @Provides @Singleton
    public SongsApplication provideApplication(){
        return application;
    }
    @Provides @Singleton
    public Context provideContext(){
        return application;
    }

}
