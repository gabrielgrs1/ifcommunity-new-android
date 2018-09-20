package ifcommunity.com.br.ifcommunity.utils.validator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

public class ValidateEmail implements IValidator {
    public static final String EMAIL_REGEX = ".+@.+\\..+";
    private final EditText emailEditText;
    private final TextInputLayout emailInputLayout;
    private final DefaultValidation defaultValidation;

    public ValidateEmail(TextInputLayout emailInputLayout) {
        this.emailInputLayout = emailInputLayout;
        this.emailEditText = emailInputLayout.getEditText();
        this.defaultValidation = new DefaultValidation(this.emailInputLayout);
    }

    private boolean defaultValidation(String email) {
        if (email.matches(EMAIL_REGEX)) {
            return true;
        }
        emailInputLayout.setError("Email inválido");
        return false;
    }

    @Override
    public boolean isValid() {
        if (!defaultValidation.isValid()) return false;

        String login = emailEditText.getText().toString();
        return defaultValidation(login);
    }
}
