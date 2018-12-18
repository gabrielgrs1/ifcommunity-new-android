package ifcommunity.com.br.ifcommunity.service.api.post;

import android.util.Log;

import java.util.List;

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
public class PostService implements IPostService {

    private CallbackResponseListener postServiceListener;
    private APIClient apiClient;

    public PostService(CallbackResponseListener postServiceListener) {
        this.apiClient = IfcommunityApplication.getInstance().getApiClient();
        this.postServiceListener = postServiceListener;
    }

    @Override
    public void getPosts(String matterName, String lastPost) {
        postServiceListener.startLoading();

        IApiService postApi = this.apiClient.getRetrofit().create(IApiService.class);
        Call<List<PostResponse>> postResponse = postApi.getPosts(matterName, lastPost);

        postResponse.enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
                postServiceListener.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                    postServiceListener.onResponse(response);
                } else if (response.code() == 403) {
                    postServiceListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_worng_user_password));
                } else if (response.code() == 500) {
                    postServiceListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
                } else if (response.code() != 200) {
                    postServiceListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_unkown_error));
                }

                Log.e(IfcommunityApplication.getInstance().getString(R.string.generic_log_error), response.message());
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {
                postServiceListener.hideLoading();
                postServiceListener.onError(IfcommunityApplication.getInstance().getString(R.string.generic_server_error));
            }
        });
    }
}
