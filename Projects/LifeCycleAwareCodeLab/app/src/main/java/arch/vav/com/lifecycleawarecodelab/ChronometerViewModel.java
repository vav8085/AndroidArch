package arch.vav.com.lifecycleawarecodelab;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

/**
 * Created by vaibhav on 1/28/18.
 */

public class ChronometerViewModel extends ViewModel {

    @Nullable
    private Long mStartTime;

    @Nullable
    public Long getmStartTime() {
        return mStartTime;
    }

    public void setmStartTime(@Nullable Long mStartTime) {
        this.mStartTime = mStartTime;
    }
}
