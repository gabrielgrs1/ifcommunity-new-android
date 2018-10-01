package ifcommunity.com.br.ifcommunity.ui.activity;

import butterknife.ButterKnife;
import ifcommunity.com.br.ifcommunity.R;

public class RegisterActivity extends GenericActivity {
    @Override
    public void setLayout() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {

    }
}
