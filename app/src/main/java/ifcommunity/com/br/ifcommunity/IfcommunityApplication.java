package ifcommunity.com.br.ifcommunity;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import ifcommunity.com.br.ifcommunity.service.api.APIClient;
import ifcommunity.com.br.ifcommunity.service.api.login.LoginResponse;

public class IfcommunityApplication extends Application {

    private static IfcommunityApplication ifcommunityApplication;
    private APIClient apiClient;
    private LoginResponse user;

    @Override
    public void onCreate() {
        super.onCreate();

        ifcommunityApplication = this;
        setApiClient();
    }

    private void setApiClient() {
        apiClient = new APIClient(this, "https://ifcommunity.herokuapp.com");
    }

    public synchronized static IfcommunityApplication getInstance() {
        return ifcommunityApplication;
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public APIClient getApiClient() {
        return apiClient;
    }

    public void setUser(LoginResponse loginResponse) {
        user = loginResponse;
    }

    public LoginResponse getUser() {
        return user;
    }
}
