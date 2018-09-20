package ifcommunity.com.br.ifcommunity.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.irozon.sneaker.Sneaker;

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
                    .setTitle("Erro!!")
                    .setDuration(8000)
                    .setIcon(R.drawable.ic_signal_wifi_off_black, Color.WHITE, false)
                    .setMessage("Verifique sua conexão com a internet!")
                    .sneak(Color.DKGRAY);
            return false;
        }

        return true;
    }

    public abstract void setLayout();

    public abstract void loadingMethods();
}
