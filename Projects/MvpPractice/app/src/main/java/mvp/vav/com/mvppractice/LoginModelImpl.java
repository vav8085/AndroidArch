package mvp.vav.com.mvppractice;

import android.os.Handler;

/**
 * Created by z179905 on 4/28/17.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void doLogin(final String userName, final String passWord, final OnLoginFinishedListener loginFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if(userName.equalsIgnoreCase("")){
                    error=true;
                    loginFinishedListener.onUsernameError();
                }
                if(passWord.equalsIgnoreCase("")){
                    error=true;
                    loginFinishedListener.onPasswordError();
                }
                if(!error){
                    loginFinishedListener.onSuccess();
                }
            }
        },4000);
    }
}
