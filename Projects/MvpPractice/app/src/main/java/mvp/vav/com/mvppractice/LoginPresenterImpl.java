package mvp.vav.com.mvppractice;

/**
 * Created by z179905 on 4/27/17.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginModel.OnLoginFinishedListener {
    LoginView view;
    LoginModel model;
    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        model = new LoginModelImpl();
    }

    @Override
    public void startLogin(String username, String password) {
        view.showGreyScreen();
        view.showProgress();
        model.doLogin(username,password,this);
    }


    @Override
    public void onUsernameError() {
        view.showToast("Username cannot be blank!");
        hideLoading();
    }

    @Override
    public void onPasswordError() {
        view.showToast("Password cannot be blank!");
       hideLoading();
    }

    @Override
    public void onSuccess() {
        view.showToast("Login Successful!");
       hideLoading();
    }

    public void hideLoading(){
        view.hideGreyScreen();
        view.hideProgress();
    }
}
