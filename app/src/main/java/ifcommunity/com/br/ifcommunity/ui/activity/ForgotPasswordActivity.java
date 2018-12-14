package ifcommunity.com.br.ifcommunity.ui.activity;


import android.content.Context;
import android.graphics.Color;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.password_recovery.PasswordRecoveryResponse;
import ifcommunity.com.br.ifcommunity.service.api.password_recovery.PasswordRecoveryService;
import ifcommunity.com.br.ifcommunity.utils.validator.IValidator;
import ifcommunity.com.br.ifcommunity.utils.validator.ValidateEmail;

public class ForgotPasswordActivity extends GenericActivity implements PasswordRecoveryService.PasswordRecoveryListener {

    Context context = this;
    private final List<IValidator> validatorList = new ArrayList<>();

    @BindView(R.id.forgot_password_mail_input_layout)
    TextInputLayout mailInputLayout;

    @BindView(R.id.forgot_password_mail_edittext)
    EditText emailEditText;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {

    }

    @Override
    public void response(PasswordRecoveryResponse passwordRecoveryResponse) {

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

    @OnClick(R.id.forgot_password_back_button)
    void backToLogin() {
        onBackPressed();
    }

    @OnClick(R.id.forgot_password_send_button)
    void sendRecoveryPasswordEmailButtonAction() {
        if (validateAllFields() && checkInternet()) {
            sendRecoveryMail();
        }
    }

    private void sendRecoveryMail() {
        buildGenericAlert(IfcommunityApplication.getInstance().getString(R.string.generic_sorry_title),
                IfcommunityApplication.getInstance().getString(R.string.generic_not_implemented),
                8000,
                Color.DKGRAY
        );

        //TODO Fazer lógica de envio de email
    }

    private void validateEmail() {
        final ValidateEmail validateEmail = new ValidateEmail(mailInputLayout);
        emailEditText.setOnFocusChangeListener((v, hasFocus) -> {
            validatorList.add(validateEmail);
            if (!hasFocus) {
                validateEmail.isValid();
            }
        });
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
