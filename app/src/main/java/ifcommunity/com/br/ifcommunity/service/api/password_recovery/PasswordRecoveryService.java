package ifcommunity.com.br.ifcommunity.service.api.password_recovery;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Objects;

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
public class PasswordRecoveryService implements IPasswordRecoveryService {

    private PasswordRecoveryListener passwordRecoveryListener;
    private APIClient apiClient;

    public PasswordRecoveryService(PasswordRecoveryListener passwordRecoveryListener) {
        this.apiClient = IfcommunityApplication.getInstance().getApiClient();
        this.passwordRecoveryListener = passwordRecoveryListener;
    }

    @Override
    public void recoveryPassword(PasswordRecoveryRequest passwordRecoveryRequest) {
        passwordRecoveryListener.startLoading();

        PasswordRecoveryApi passwordRecoveryApi = this.apiClient.getRetrofit().create(PasswordRecoveryApi.class);
        Call<PasswordRecoveryResponse> loginResponse = passwordRecoveryApi.login(passwordRecoveryRequest);

        loginResponse.enqueue(new Callback<PasswordRecoveryResponse>() {
            @Override
            public void onResponse(@NonNull Call<PasswordRecoveryResponse> call, @NonNull Response<PasswordRecoveryResponse> response) {
                passwordRecoveryListener.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    passwordRecoveryListener.response(response.body());
                } else if (response.code() == 500) {
                    passwordRecoveryListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
                } else if (response.code() != 200) {
                    passwordRecoveryListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_unkown_error));
                }

                Log.e(IfcommunityApplication.getInstance().getString(R.string.generic_log_error), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<PasswordRecoveryResponse> call, @NonNull Throwable t) {
                passwordRecoveryListener.hideLoading();
                passwordRecoveryListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
            }
        });
    }

    public interface PasswordRecoveryListener {
        void response(PasswordRecoveryResponse passwordRecoveryResponse);

        void startLoading();

        void hideLoading();

        void serverError(String message);
    }

}
