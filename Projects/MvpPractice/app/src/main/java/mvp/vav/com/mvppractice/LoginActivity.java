package mvp.vav.com.mvppractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    EditText userName;
    EditText passWord;
    Button loginButton;
    ProgressBar progressBar;
    FrameLayout greyScreen;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Init Variables
        initVariables();
        //Assign views
        assignViews();
        //ClickListners
        setOnClickListners(this);
    }

    private void setOnClickListners(View.OnClickListener clickListners){
        loginButton.setOnClickListener(clickListners);
    }

    private void initVariables() {
        presenter = new LoginPresenterImpl(this);
    }

    private void assignViews() {
        userName = (EditText) findViewById(R.id.user_name);
        passWord = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login_button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        greyScreen = (FrameLayout) findViewById(R.id.grey_screen);
    }

    @Override
    public void setUsername(String username) {
        userName.setText(username);
    }

    @Override
    public void setPassword(String password) {
        passWord.setText(password);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showGreyScreen() {
        greyScreen.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideGreyScreen() {
        greyScreen.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button)
            presenter.startLogin(userName.getText().toString(),passWord.getText().toString());
    }
}
