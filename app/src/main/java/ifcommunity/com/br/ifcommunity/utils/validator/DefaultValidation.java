package ifcommunity.com.br.ifcommunity.utils.validator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

public class DefaultValidation implements IValidator {

    private static final String REQUIRED_FIELD = "Campo obrigatório";
    private final TextInputLayout textInputLayout;
    private final EditText field;

    public DefaultValidation(TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
        this.field = this.textInputLayout.getEditText();
    }

    private boolean validateRequiredField() {
        String text = field.getText().toString();
        if (text.isEmpty()) {
            textInputLayout.setError(REQUIRED_FIELD);
            return false;
        }
        return true;
    }

    @Override
    public boolean isValid(){
        if(!validateRequiredField()) return false;
        removeError();
        return true;
    }

    private void removeError() {
        textInputLayout.setError(null);
        textInputLayout.setErrorEnabled(false);
    }

}
