package ifcommunity.com.br.ifcommunity.service.api.login;

import androidx.annotation.NonNull;
import android.util.Log;

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

                if (response.isSuccessful() && response.body() != null)  {
                    loginListener.response(response.body());
                    IfcommunityApplication.getInstance().setUser(response.body());
                } else if (response.code() == 403) {
                    loginListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_worng_user_password));
                } else if (response.code() == 500) {
                    loginListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
                } else if (response.code() != 200) {
                    loginListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_unkown_error));
                }

                Log.e(IfcommunityApplication.getInstance().getString(R.string.generic_log_error), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                loginListener.hideLoading();
                loginListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
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
