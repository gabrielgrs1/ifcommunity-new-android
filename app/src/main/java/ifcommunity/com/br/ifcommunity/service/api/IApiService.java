package ifcommunity.com.br.ifcommunity.service.api;

import java.util.List;

import ifcommunity.com.br.ifcommunity.service.api.login.LoginRequest;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginResponse;
import ifcommunity.com.br.ifcommunity.service.api.matter.MatterResponse;
import ifcommunity.com.br.ifcommunity.service.api.password_recovery.PasswordRecoveryRequest;
import ifcommunity.com.br.ifcommunity.service.api.password_recovery.PasswordRecoveryResponse;
import ifcommunity.com.br.ifcommunity.service.api.post.PostResponse;
import ifcommunity.com.br.ifcommunity.service.api.register.RegisterRequest;
import ifcommunity.com.br.ifcommunity.service.api.register.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by gabrielgrs
 * Date: 18/12/18
 * Time: 8:34 AM
 * Project: ifcommunity-new-android
 */
public interface IApiService {

    @GET("/post/get")
    Call<List<PostResponse>> getPosts(@Query("name") String matterName, @Query("lastPost") String lastPost);

    @GET("/matter")
    Call<List<MatterResponse>> getMatters();

    @POST("/user/passwordRecovery")
    Call<PasswordRecoveryResponse> passwordRecovery(@Body final PasswordRecoveryRequest passwordRecoveryRequest);

    @POST("/user/login")
    Call<LoginResponse> login(@Body final LoginRequest loginRequest);

    @GET("/user/verify")
    Call<String> verify(@Query(value = "verifyString") String verifyString);

    @POST("/user")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);
}
