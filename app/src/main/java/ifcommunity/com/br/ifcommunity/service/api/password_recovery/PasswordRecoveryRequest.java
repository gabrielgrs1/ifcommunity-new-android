package ifcommunity.com.br.ifcommunity.service.api.password_recovery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by paulo.
 * Date: 11/08/18
 * Time: 15:17
 */
public class PasswordRecoveryRequest implements Serializable {

    @SerializedName("email")
    private String email;

    public PasswordRecoveryRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
