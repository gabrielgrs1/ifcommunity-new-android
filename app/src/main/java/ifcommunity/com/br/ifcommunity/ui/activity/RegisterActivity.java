package ifcommunity.com.br.ifcommunity.ui.activity;

import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.register.RegisterResponse;
import ifcommunity.com.br.ifcommunity.service.api.register.RegisterService;

public class RegisterActivity extends GenericActivity implements RegisterService.RegisterServiceListener{


    @Override
    public void setLayout() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {

    }

    @Override
    public void responseRegister(RegisterResponse registerResponse) {

    }

    @Override
    public void responseVerify(String stringResponse) {

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
}
