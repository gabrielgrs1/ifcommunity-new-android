package ifcommunity.com.br.ifcommunity.service.api.login;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 15:36
 */
public interface ILoginService {

    /**
     * Request for Login in Application
     *
     * @param loginRequest
     */
    void login(LoginRequest loginRequest);
}
