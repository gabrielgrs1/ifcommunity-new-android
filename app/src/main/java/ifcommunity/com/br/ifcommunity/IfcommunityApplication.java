package ifcommunity.com.br.ifcommunity;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import ifcommunity.com.br.ifcommunity.service.api.APIClient;

public class IfcommunityApplication extends Application {

    private static IfcommunityApplication ifcommunityApplication;
    private APIClient apiClient;

    public synchronized static IfcommunityApplication getInstance() {
        return ifcommunityApplication;
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ifcommunityApplication = this;
        apiClient = new APIClient(this, "https://ifcommunity.herokuapp.com");
    }

    public APIClient getApiClient() {
        return apiClient;

    }
}
