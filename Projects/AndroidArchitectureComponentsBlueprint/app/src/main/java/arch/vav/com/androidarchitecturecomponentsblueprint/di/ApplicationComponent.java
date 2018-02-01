package arch.vav.com.androidarchitecturecomponentsblueprint.di;

import javax.inject.Singleton;

import arch.vav.com.androidarchitecturecomponentsblueprint.ui.MainActivity;
import dagger.Component;

/**
 * Created by Vaibhav on 1/31/18.
 */

@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}

