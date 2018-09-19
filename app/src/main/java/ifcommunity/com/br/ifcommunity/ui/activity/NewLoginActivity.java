package ifcommunity.com.br.ifcommunity.ui.activity;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginRequest;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginResponse;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginService;

public class NewLoginActivity extends GenericActivity implements LoginService.LoginServiceListener {

    Context context = this;

    @BindView(R.id.login_login_edittext)
    EditText loginEditText;

    @BindView(R.id.login_password_edittext)
    EditText passwordEditText;


    @Override
    public void setLayout() {
        setContentView(R.layout.activity_new_login);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {

    }

    @OnClick(R.id.login_login_button)
    void login() {
        loginService();
    }

    @Override
    public void response(LoginResponse loginResponse) {
        Toast.makeText(context, loginResponse.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void serverError(String message) {

    }

    private void loginService() {
        String login = Objects.requireNonNull(loginEditText.getText().toString());
        String senha = Objects.requireNonNull(passwordEditText.getText().toString());

        LoginRequest request = new LoginRequest(login, senha);

        new LoginService(this).login(request);
    }
}
