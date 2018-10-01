package ifcommunity.com.br.ifcommunity.service.api.register;

import android.support.annotation.NonNull;
import android.util.Log;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.APIClient;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterService implements IRegisterService {

    private RegisterServiceListener registerListener;
    private APIClient apiClient;

    public RegisterService(RegisterServiceListener registerListener) {
        this.apiClient = IfcommunityApplication.getInstance().getApiClient();
        this.registerListener = registerListener;
    }


    @Override
    public void verify(String verifyString) {

    }

    @Override
    public void register(RegisterRequest registerRequest) {
        registerListener.startLoading();

        RegisterApi registerApi = this.apiClient.getRetrofit().create(RegisterApi.class);
        Call<RegisterResponse> registerResponse = registerApi.register(registerRequest);


        registerResponse.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                registerListener.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    registerListener.responseRegister(response.body());
                    IfcommunityApplication.getInstance().setUser(LoginResponse.transformRegisterToLogin(response.body()));
                } else if (response.code() == 403) {
                    registerListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_worng_user_password));
                } else if (response.code() == 500) {
                    registerListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
                } else if (response.code() != 200) {
                    registerListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_unkown_error));
                }

                Log.e(IfcommunityApplication.getInstance().getString(R.string.generic_log_error), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                registerListener.hideLoading();
                registerListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
            }
        });
    }


    public interface RegisterServiceListener {
        void responseRegister(RegisterResponse registerResponse);

        void responseVerify(String stringResponse);

        void startLoading();

        void hideLoading();

        void serverError(String message);
    }
}