package mvp.vav.com.mvppractice;

/**
 * Created by z179905 on 4/27/17.
 */

public interface LoginView {
    public void setUsername(String username);
    public void setPassword(String password);
    public void showProgress();
    public void hideProgress();
    public void showGreyScreen();
    public void hideGreyScreen();
    public void showToast(String toast);
}

