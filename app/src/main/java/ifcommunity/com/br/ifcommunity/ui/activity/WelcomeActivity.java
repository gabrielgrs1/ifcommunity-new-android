package ifcommunity.com.br.ifcommunity.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ifcommunity.com.br.ifcommunity.R;

public class WelcomeActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.welcome_login_button)
    void changeToLoginScreen() {
        Intent intentToLoginScreen = new Intent(context, NewLoginActivity.class);
        startActivity(intentToLoginScreen);
    }
}
