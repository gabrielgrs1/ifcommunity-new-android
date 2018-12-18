package ifcommunity.com.br.ifcommunity.service.api.password_recovery;

import android.util.Log;

import androidx.annotation.NonNull;
import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.APIClient;
import ifcommunity.com.br.ifcommunity.service.api.CallbackResponseListener;
import ifcommunity.com.br.ifcommunity.service.api.IApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 15:35
 */
public class PasswordRecoveryService implements IPasswordRecoveryService {

    private CallbackResponseListener passwordRecoveryListener;
    private APIClient apiClient;

    public PasswordRecoveryService(CallbackResponseListener passwordRecoveryListener) {
        this.apiClient = IfcommunityApplication.getInstance().getApiClient();
        this.passwordRecoveryListener = passwordRecoveryListener;
    }

    @Override
    public void recoveryPassword(PasswordRecoveryRequest passwordRecoveryRequest) {
        passwordRecoveryListener.startLoading();

        IApiService passwordRecoveryApi = this.apiClient.getRetrofit().create(IApiService.class);
        Call<PasswordRecoveryResponse> loginResponse = passwordRecoveryApi.passwordRecovery(passwordRecoveryRequest);

        loginResponse.enqueue(new Callback<PasswordRecoveryResponse>() {
            @Override
            public void onResponse(@NonNull Call<PasswordRecoveryResponse> call, @NonNull Response<PasswordRecoveryResponse> response) {
                passwordRecoveryListener.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    passwordRecoveryListener.onResponse(response);
                } else if (response.code() == 500) {
                    passwordRecoveryListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
                } else if (response.code() != 200) {
                    passwordRecoveryListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_unkown_error));
                }

                Log.e(IfcommunityApplication.getInstance().getString(R.string.generic_log_error), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<PasswordRecoveryResponse> call, @NonNull Throwable t) {
                passwordRecoveryListener.hideLoading();
                passwordRecoveryListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
            }
        });
    }
}
