package ifcommunity.com.br.ifcommunity.service.api.profile;

import android.util.Log;

import androidx.annotation.NonNull;
import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.APIClient;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileService implements IProfileService {

    private ProfileServiceListener profileListener;
    private APIClient apiClient;

    public ProfileService(ProfileServiceListener profileListener) {
        this.apiClient = IfcommunityApplication.getInstance().getApiClient();
        this.profileListener = profileListener;
    }


    @Override
    public void verify(String verifyString) {

    }

    @Override
    public void profile(ProfileRequest profileRequest) {
        profileListener.startLoading();

        ProfileApi profileApi = this.apiClient.getRetrofit().create(ProfileApi.class);
        Call<ProfileResponse> profileResponse = profileApi.profile(profileRequest);


        profileResponse.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProfileResponse> call, @NonNull Response<ProfileResponse> response) {
                profileListener.hideLoading();

                 if (response.code() == 403) {
                    profileListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_worng_user_password));
                } else if (response.code() == 500) {
                    profileListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
                } else if (response.code() != 200) {
                    profileListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_unkown_error));
                }

                Log.e(IfcommunityApplication.getInstance().getString(R.string.generic_log_error), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<ProfileResponse> call, @NonNull Throwable t) {
                profileListener.hideLoading();
                profileListener.serverError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
            }
        });
    }


    public interface ProfileServiceListener {
        void responseProfile(ProfileResponse profileResponse);

        void responseVerify(String stringResponse);

        void startLoading();

        void hideLoading();

        void serverError(String message);
    }
}