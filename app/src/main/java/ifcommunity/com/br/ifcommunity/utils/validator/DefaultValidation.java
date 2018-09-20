package ifcommunity.com.br.ifcommunity.utils.validator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;

public class DefaultValidation implements IValidator {

    private final TextInputLayout textInputLayout;
    private final EditText field;

    DefaultValidation(TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
        this.field = this.textInputLayout.getEditText();
    }

    private boolean validateRequiredField() {
        String text = field.getText().toString();
        if (text.isEmpty()) {
            textInputLayout.setError(IfcommunityApplication.getInstance().getString(R.string.generic_required_field));
            return false;
        }
        return true;
    }

    @Override
    public boolean isValid() {
        if (!validateRequiredField()) return false;
        removeError();
        return true;
    }

    private void removeError() {
        textInputLayout.setError(null);
        textInputLayout.setErrorEnabled(false);
    }

}
