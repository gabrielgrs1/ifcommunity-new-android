package ifcommunity.com.br.ifcommunity.utils.validator;

import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;

public class ValidateLogin implements IValidator {

    public static final String LOGIN_REGEX = "\\w{6,}";
    private final EditText loginEditText;
    private final TextInputLayout loginInputLayout;
    private final DefaultValidation defaultValidation;

    public ValidateLogin(TextInputLayout loginInputLayout) {
        this.loginInputLayout = loginInputLayout;
        this.loginEditText = loginInputLayout.getEditText();
        this.defaultValidation = new DefaultValidation(this.loginInputLayout);
    }

    private boolean defaultValidation(String login) {
        if (login.matches(LOGIN_REGEX)) {
            return true;
        }
        loginInputLayout.setError(IfcommunityApplication.getInstance().getString(R.string.generic_invalid_login));
        return false;
    }

    @Override
    public boolean isValid() {
        if (!defaultValidation.isValid()) return false;

        String login = loginEditText.getText().toString();
        return defaultValidation(login);
    }
}
