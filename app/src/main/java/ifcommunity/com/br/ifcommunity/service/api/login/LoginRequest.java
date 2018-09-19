package ifcommunity.com.br.ifcommunity.service.api.login;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 15:17
 */
public class LoginRequest implements Serializable {

    @SerializedName("user")
    private String user;

    @SerializedName("password")
    private String password;

    public LoginRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public LoginRequest setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
