package ifcommunity.com.br.ifcommunity.service.api.register;

import androidx.annotation.NonNull;
import android.util.Log;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.APIClient;
import ifcommunity.com.br.ifcommunity.service.api.CallbackResponseListener;
import ifcommunity.com.br.ifcommunity.service.api.IApiService;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterService implements IRegisterService {

    private CallbackResponseListener registerListener;
    private APIClient apiClient;

    public RegisterService(CallbackResponseListener registerListener) {
        this.apiClient = IfcommunityApplication.getInstance().getApiClient();
        this.registerListener = registerListener;
    }


    @Override
    public void verify(String verifyString) {

    }

    @Override
    public void register(RegisterRequest registerRequest) {
        registerListener.startLoading();

        IApiService registerApi = this.apiClient.getRetrofit().create(IApiService.class);
        Call<RegisterResponse> registerResponse = registerApi.register(registerRequest);


        registerResponse.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                registerListener.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    registerListener.onResponse(response);
                    IfcommunityApplication.getInstance().setUser(LoginResponse.transformRegisterToLogin(response.body()));
                } else if (response.code() == 403) {
                    registerListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_worng_user_password));
                } else if (response.code() == 500) {
                    registerListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
                } else if (response.code() != 200) {
                    registerListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_unkown_error));
                }

                Log.e(IfcommunityApplication.getInstance().getString(R.string.generic_log_error), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                registerListener.hideLoading();
                registerListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
            }
        });
    }
}