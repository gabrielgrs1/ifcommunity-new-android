package ifcommunity.com.br.ifcommunity.service.api.password_recovery;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 16:42
 */
public interface PasswordRecoveryApi {
    @POST("/user/passwordRecovery")
    Call<PasswordRecoveryResponse> passwordRecovery(@Body final PasswordRecoveryRequest passwordRecoveryRequest);
}
