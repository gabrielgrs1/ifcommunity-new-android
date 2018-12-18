package ifcommunity.com.br.ifcommunity.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.ui.adapter.GetPostMatterListener;
import ifcommunity.com.br.ifcommunity.ui.fragment.MatterFragment;
import ifcommunity.com.br.ifcommunity.ui.fragment.PostFragment;

public class LoggedActivity extends GenericActivity implements GetPostMatterListener {

    public static final int GROUP_POSITION = 0;
    public static final int PROFILE_POSITION = 3;
    public static final int MENU_POSITION = 4;
    public static final int POST_POSITION = 2;
    public static final int MATTER_POSITION = 1;

    @BindView(R.id.logged_bottom_navigation)
    AHBottomNavigation bottomNavigation;

    private FragmentManager mFragmentManager;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_logged);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {
        configureBottomBar();
        configureFragmentManager();
    }

    private void configureFragmentManager() {
        mFragmentManager = getSupportFragmentManager();
        configureFirstFragmentAsPostFragment(mFragmentManager);
    }

    private void configureFirstFragmentAsPostFragment(FragmentManager fragmentManager) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.logged_content_framelayout, new PostFragment());
        fragmentTransaction.commit();
    }

    private void configureBottomBar() {
        AHBottomNavigationItem itemGroup = new AHBottomNavigationItem("Grupos", R.drawable.team, R.color.colorPrimaryButton);
        AHBottomNavigationItem itemMatters = new AHBottomNavigationItem("Materias", R.drawable.books, R.color.colorPrimaryButton);
        AHBottomNavigationItem itemPost = new AHBottomNavigationItem("Postagens", R.drawable.blog, R.color.colorPrimaryButton);
        AHBottomNavigationItem itemProfile = new AHBottomNavigationItem("Perfil", R.drawable.user, R.color.colorPrimaryButton);
        AHBottomNavigationItem itemMenu = new AHBottomNavigationItem("Menu", R.drawable.menu, R.color.colorPrimaryButton);

        bottomNavigation.addItem(itemGroup);
        bottomNavigation.addItem(itemMatters);
        bottomNavigation.addItem(itemPost);
        bottomNavigation.addItem(itemProfile);
        bottomNavigation.addItem(itemMenu);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        bottomNavigation.setAccentColor(R.color.colorPrimaryButton);

        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setCurrentItem(POST_POSITION);

        bottomNavigation.setOnTabSelectedListener((position, wasSelected) -> {
            switch (position) {
                case POST_POSITION:
                    setPostFragment("");
                    break;
                case MATTER_POSITION:
                    setMatterFragment();
                    break;
                case GROUP_POSITION:
                    Toast.makeText(this, "Funcionalidade nao implementada!", Toast.LENGTH_SHORT).show();
                    break;
                case PROFILE_POSITION:
                    Toast.makeText(this, "Funcionalidade nao implementada!", Toast.LENGTH_SHORT).show();
                    break;
                case MENU_POSITION:
                    Toast.makeText(this, "Funcionalidade nao implementada!", Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        });
    }

    private void setMatterFragment() {
        Objects.requireNonNull(getSupportActionBar()).setTitle("Matérias");
        bottomNavigation.setCurrentItem(POST_POSITION);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.logged_content_framelayout, new MatterFragment());
        fragmentTransaction.commit();
    }

    private void setPostFragment(String matterName) {
        Objects.requireNonNull(getSupportActionBar()).setTitle("Postagens");
        PostFragment postFragment = new PostFragment();

        if (matterName != null) {
            Bundle bundle = new Bundle();
            bundle.putString("matter", matterName);
            postFragment.setArguments(bundle);
        }

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.logged_content_framelayout, postFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if (fragment instanceof MatterFragment) {
            MatterFragment matterFragment = (MatterFragment) fragment;
            matterFragment.setGetterPostListener(this);
        }
    }

    @Override
    public void callPostFragment(String matterName) {
        setPostFragment(matterName);
    }
}
