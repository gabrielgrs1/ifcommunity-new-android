package ifcommunity.com.br.ifcommunity.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

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

    public abstract void setLayout();

    public abstract void loadingMethods();
}
