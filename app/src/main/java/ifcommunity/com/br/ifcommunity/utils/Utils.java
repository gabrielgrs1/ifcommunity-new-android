package ifcommunity.com.br.ifcommunity.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;

/**
 * Utils for application
 */
public class Utils {

    public static boolean isOnline() {
        Context context = IfcommunityApplication.getInstance();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = null;
        if (connectivityManager != null) {
            netInfo = connectivityManager.getActiveNetworkInfo();
        }
        return (netInfo != null && netInfo.isConnected());
    }
}
