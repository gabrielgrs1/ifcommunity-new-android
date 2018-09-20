package ifcommunity.com.br.ifcommunity.utils.validator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import butterknife.BindView;
import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;

public class ValidatePassword implements IValidator {

    private static final String PASSWORD_REGEX = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,10}";
    private final EditText passwordEditText;
    private final TextInputLayout passwordInputLayout;
    private final DefaultValidation defaultValidation;

    public ValidatePassword(TextInputLayout passwordInputLayout) {
        this.passwordInputLayout = passwordInputLayout;
        this.passwordEditText = passwordInputLayout.getEditText();
        this.defaultValidation = new DefaultValidation(this.passwordInputLayout);
    }

    private boolean defaultValidation(String password) {
        if (password.matches(PASSWORD_REGEX)) {
            return true;
        }
        passwordInputLayout.setError(IfcommunityApplication.getInstance().getString(R.string.generic_invalid_password));
        return false;
    }

    @Override
    public boolean isValid() {
        if (!defaultValidation.isValid()) return false;

        String password = passwordEditText.getText().toString();
        return defaultValidation(password);
    }
}
