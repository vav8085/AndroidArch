package mvp.vav.com.mvppractice;

/**
 * Created by z179905 on 4/28/17.
 */

public interface LoginModel {
    public void doLogin(String userName, String passWord, OnLoginFinishedListener loginFinishedListener);
    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }
}
