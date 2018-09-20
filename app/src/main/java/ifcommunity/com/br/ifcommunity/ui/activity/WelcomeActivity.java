package ifcommunity.com.br.ifcommunity.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ifcommunity.com.br.ifcommunity.R;

public class WelcomeActivity extends GenericActivity {

    final Context context = this;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {

    }

    @OnClick(R.id.welcome_login_button)
    void changeToLoginScreen() {
        Intent intentToLoginScreen = new Intent(context, LoginActivity.class);
        startActivity(intentToLoginScreen);
    }
}
