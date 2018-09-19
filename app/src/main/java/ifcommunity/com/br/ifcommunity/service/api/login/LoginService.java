package ifcommunity.com.br.ifcommunity.service.api.login;

import android.support.annotation.NonNull;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 15:35
 */
public class LoginService implements ILoginService {

    private LoginServiceListener loginListener;
    private APIClient apiClient;

    public LoginService(LoginServiceListener loginListener) {
        this.apiClient = IfcommunityApplication.getInstance().getApiClient();
        this.loginListener = loginListener;
    }

    @Override
    public void login(LoginRequest loginRequest) {
        loginListener.startLoading();

        LoginApi loginApi = this.apiClient.getRetrofit().create(LoginApi.class);
        Call<LoginResponse> loginResponse = loginApi.login(loginRequest);

        loginResponse.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                loginListener.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    loginListener.response(response.body());
                } else if (response.code() != 200){
                    loginListener.serverError(IfcommunityApplication.getInstance().getString(R.string.error_server));
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                loginListener.hideLoading();
                loginListener.serverError(IfcommunityApplication.getInstance().getString(R.string.error_server));
            }
        });
    }

    public interface LoginServiceListener {
        void response(LoginResponse loginResponse);
        void startLoading();
        void hideLoading();
        void serverError(String message);
    }

}
