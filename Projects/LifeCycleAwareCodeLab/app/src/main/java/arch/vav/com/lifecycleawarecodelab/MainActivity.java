package arch.vav.com.lifecycleawarecodelab;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LiveDataTimerViewModel liveDataTimerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Chronometer example
//        ChronometerViewModel chronometerViewModel = ViewModelProviders.of(this)
//                                                    .get(ChronometerViewModel.class);
//
//        Chronometer chronometer = findViewById(R.id.chronometer);
//
//        if(chronometerViewModel.getmStartTime()==null){
//            long startTime = SystemClock.elapsedRealtime();
//            chronometerViewModel.setmStartTime(startTime);
//            chronometer.setBase(startTime);
//        }else{
//            chronometer.setBase(chronometerViewModel.getmStartTime());
//        }
//        chronometer.start();

        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);

        subscribe();

    }

    private void subscribe() {
        final Observer<Long> elaapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable Long aLong) {
                String newText = MainActivity.this.getResources().getString(R.string.seconds,aLong);
                TextView textView = findViewById(R.id.timer_textview);
                textView.setText(newText);
            }
        };
        liveDataTimerViewModel.getmElapsedTime().observe(this,elaapsedTimeObserver);
    }
}
