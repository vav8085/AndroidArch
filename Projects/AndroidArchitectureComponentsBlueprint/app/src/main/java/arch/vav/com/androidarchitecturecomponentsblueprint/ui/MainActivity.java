package arch.vav.com.androidarchitecturecomponentsblueprint.ui;

import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import arch.vav.com.androidarchitecturecomponentsblueprint.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SongsListFragment songsListFragment = new SongsListFragment();
        openFragment(songsListFragment,"songsListFragment");
    }

    private void openFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container,fragment,tag)
                .addToBackStack(null)
                .commit();
    }
}
