package ifcommunity.com.br.ifcommunity.service.api;

import retrofit2.Response;

/**
 * Created by gabrielgrs
 * Date: 18/12/18
 * Time: 8:38 AM
 * Project: ifcommunity-new-android
 */
public interface CallbackResponseListener<T> {

    void onResponse(Response<T> response);

    void onError(String message);

    void startLoading();

    void hideLoading();
}
