package ifcommunity.com.br.ifcommunity.service.api.matter;

import android.util.Log;

import java.util.List;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MMarafelli.
 * Date: 17/12/18
 * Time: 15:35
 */
public class MatterService implements IMatterService {

    private MatterServiceListener matterServiceListener;
    private APIClient apiClient;

    public MatterService(MatterServiceListener matterServiceListener) {
        this.apiClient = IfcommunityApplication.getInstance().getApiClient();
        this.matterServiceListener = matterServiceListener;
    }

    @Override
    public void getMatters(Integer studentId) {
        matterServiceListener.startLoading();

        MatterApi matterApi = this.apiClient.getRetrofit().create(MatterApi.class);
        Call<List<MatterResponse>> matterResponse = matterApi.getMatters(studentId);

        matterResponse.enqueue(new Callback<List<MatterResponse>>() {
            @Override
            public void onResponse(Call<List<MatterResponse>> call, Response<List<MatterResponse>> response) {
                matterServiceListener.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    matterServiceListener.onResponse(response.body());
                } else if (response.code() == 403) {
                    matterServiceListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_invalid_matter));
                } else if (response.code() == 500) {
                    matterServiceListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
                } else if (response.code() != 200) {
                    matterServiceListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_unkown_error));
                }

                Log.e(IfcommunityApplication.getInstance().getString(R.string.generic_log_error), response.message());
            }

            @Override
            public void onFailure(Call<List<MatterResponse>> call, Throwable t) {
                matterServiceListener.hideLoading();
                matterServiceListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
            }
        });
    }

    public interface MatterServiceListener {
        void onResponse(List<MatterResponse> matterResponse);

        void onError(String message);

        void startLoading();

        void hideLoading();
    }

}
