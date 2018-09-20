package ifcommunity.com.br.ifcommunity.ui.activity;


import butterknife.OnClick;
import ifcommunity.com.br.ifcommunity.R;

public class ForgotPasswordActivity extends GenericActivity {


    @Override
    public void setLayout() {
        setContentView(R.layout.activity_forgot_password);

    }

    @Override
    public void loadingMethods() {

    }

    @OnClick(R.id.forgot_password_back_button)
    void backToLogin() {
        onBackPressed();
    }
}
