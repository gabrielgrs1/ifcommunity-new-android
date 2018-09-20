package ifcommunity.com.br.ifcommunity.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;

import net.grandcentrix.tray.AppPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginRequest;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginResponse;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginService;
import ifcommunity.com.br.ifcommunity.utils.validator.IValidator;
import ifcommunity.com.br.ifcommunity.utils.validator.ValidateLogin;
import ifcommunity.com.br.ifcommunity.utils.validator.ValidatePassword;

public class LoginActivity extends GenericActivity implements LoginService.LoginServiceListener {

    Context context = this;
    private final List<IValidator> validatorList = new ArrayList<>();
    private AppPreferences appPreferences;


    @BindView(R.id.login_login_edittext)
    EditText loginEditText;

    @BindView(R.id.login_password_edittext)
    EditText passwordEditText;

    @BindView(R.id.progress_bar_login)
    ProgressBar progressBarLogin;

    @BindView(R.id.login_login_input_layout)
    TextInputLayout loginInputLayout;

    @BindView(R.id.login_password_input_layout)
    TextInputLayout passwordInputLayout;

    @BindView(R.id.login_remember_checkbox)
    CheckBox rememberCheckbox;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {
        appPreferences = new AppPreferences(context);
        loadValidation();
        loadSavedUser();
    }

    @Override
    public void response(LoginResponse loginResponse) {
        Toast.makeText(context, "Usuário logado: " + loginResponse.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startLoading() {
        progressBarLogin.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        progressBarLogin.setVisibility(View.GONE);

    }

    @Override
    public void serverError(String message) {
        Sneaker.with(this)
                .setTitle(IfcommunityApplication.getInstance().getString(R.string.generic_erro_title))
                .setDuration(8000)
                .setMessage(message)
                .sneakError();
    }

    @OnClick(R.id.login_login_button)
    void login() {
        if (validateAllFields() && checkInternet()) {
            loginService();
            remeberCheckToggle();
        }
    }

    @OnClick(R.id.login_back_button)
    void backToWelcome() {
        onBackPressed();
    }

    @OnClick(R.id.login_forgot_passsword_button)
    void changeScreenToForgotPassword() {
        Intent intent = new Intent(context, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    private void remeberCheckToggle() {
        if (rememberCheckbox.isChecked()) {
            appPreferences.put("user", loginEditText.getText().toString());
            appPreferences.put("password", passwordEditText.getText().toString());
        } else {
            appPreferences.put("user", "");
            appPreferences.put("password", "");
        }
    }

    private void loginService() {
        String login = Objects.requireNonNull(loginEditText.getText().toString());
        String password = Objects.requireNonNull(passwordEditText.getText().toString());

        LoginRequest request = new LoginRequest(login, password);
        new LoginService(this).login(request);
    }


    private void validateLogin() {
        final ValidateLogin validateLogin = new ValidateLogin(loginInputLayout);
        validatorList.add(validateLogin);
        loginEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                validateLogin.isValid();
            }
        });
    }

    private void validatePassword() {
        final ValidatePassword validatePassword = new ValidatePassword(passwordInputLayout);
        validatorList.add(validatePassword);
        passwordEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                validatePassword.isValid();
            }
        });
    }

    private void loadValidation() {
        validateLogin();
        validatePassword();
    }

    private void loadSavedUser() {
        loginEditText.setText(appPreferences.getString("user", ""));
        passwordEditText.setText(appPreferences.getString("password", ""));
        if (!Objects.requireNonNull(appPreferences.getString("user", "")).isEmpty()) {
            rememberCheckbox.setChecked(true);
        }
    }


    private boolean validateAllFields() {
        boolean fieldsIsValid = true;
        for (IValidator validator :
                validatorList) {
            if (!validator.isValid()) {
                fieldsIsValid = false;
            }
        }
        return fieldsIsValid;
    }
}
