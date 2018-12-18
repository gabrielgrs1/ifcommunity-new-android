package ifcommunity.com.br.ifcommunity.service.api.profile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProfileApi {

    @GET("/user/verify")
    Call<String> verify(@Query(value = "verifyString") String verifyString);

    @POST("/user")
    Call<ProfileResponse> profile(@Body ProfileRequest profileRequest);
}
