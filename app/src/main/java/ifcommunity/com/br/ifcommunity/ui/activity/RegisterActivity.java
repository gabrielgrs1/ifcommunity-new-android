package ifcommunity.com.br.ifcommunity.ui.activity;

import butterknife.ButterKnife;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.CallbackResponseListener;
import ifcommunity.com.br.ifcommunity.service.api.register.RegisterResponse;
import retrofit2.Response;

public class RegisterActivity extends GenericActivity implements CallbackResponseListener {


    @Override
    public void setLayout() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {

    }

    @Override
    public void onResponse(Response response) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
