package ifcommunity.com.br.ifcommunity.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.irozon.sneaker.Sneaker;

import ifcommunity.com.br.ifcommunity.IfcommunityApplication;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.utils.Utils;

/**
 * Created by gabrielgrs
 * Date: 19/09/2018
 * Time: 7:18 PM
 * Project: ifcommunity-new-android
 */
public abstract class GenericActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startMethods();
    }

    protected void startMethods() {
        fragmentManager = getSupportFragmentManager();
        setLayout();
        loadingMethods();
    }

    protected void setHomeButton() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected boolean checkInternet() {
        if (!Utils.isOnline()) {
            Sneaker.with(this)
                    .setTitle(IfcommunityApplication.getInstance().getString(R.string.generic_erro_title))
                    .setDuration(8000)
                    .setIcon(R.drawable.ic_signal_wifi_off_black, Color.WHITE, false)
                    .setMessage(IfcommunityApplication.getInstance().getString(R.string.generic_no_connection_message))
                    .sneak(Color.DKGRAY);
            return false;
        }

        return true;
    }

    protected void buildGenericAlert(String title, String message, int duration, int color) {
        Sneaker.with(this)
                .setTitle(title)
                .setDuration(duration)
                .setMessage(message)
                .sneak(color);
    }

    public abstract void setLayout();

    public abstract void loadingMethods();
}
