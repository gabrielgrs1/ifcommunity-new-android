package ifcommunity.com.br.ifcommunity.service.api.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 16:42
 */
public interface LoginApi {

    /**
     * Request for login in Application
     *
     * @param loginRequest
     * @return
     */
    @POST("/user/login")
    Call<LoginResponse> login(@Body final LoginRequest loginRequest);
}
