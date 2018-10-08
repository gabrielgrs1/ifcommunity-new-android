package ifcommunity.com.br.ifcommunity.service.api.register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegisterApi {

    @GET("/user/verify")
    Call<String> verify(@Query(value = "verifyString") String verifyString);

    @POST("/user")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);
}
