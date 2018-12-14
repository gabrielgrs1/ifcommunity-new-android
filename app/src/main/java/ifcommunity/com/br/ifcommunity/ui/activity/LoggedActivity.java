package ifcommunity.com.br.ifcommunity.ui.activity;

import android.graphics.Color;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.tuyenmonkey.mkloader.MKLoader;

import java.util.List;
import java.util.Objects;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.post.PostResponse;
import ifcommunity.com.br.ifcommunity.service.api.post.PostService;
import ifcommunity.com.br.ifcommunity.ui.adapter.PostAdapter;

public class LoggedActivity extends GenericActivity implements PostService.PostServiceListener, SwipeRefreshLayout.OnRefreshListener {

    public static final int POST_POSITION = 2;

    @BindView(R.id.logged_post_recyclerview)
    RecyclerView mPostRecyclerView;

    @BindView(R.id.logged_loading_mkloader)
    MKLoader mLoaderPostMkLoader;

    @BindView(R.id.logged_post_swiperefreshlayout)
    SwipeRefreshLayout mPostSwipeRefreshLayout;

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_logged);
        ButterKnife.bind(this);
    }

    @Override
    public void loadingMethods() {
        getPosts();
        configureBottomBar();
        configureActionBar();
        configureListeners();
        configureRefreshLayout();

    }

    private void configureRefreshLayout() {
        mPostSwipeRefreshLayout.setColorScheme(R.color.colorPrimary);
    }

    @Override
    public void onResponse(List<PostResponse> postResponse) {
        configurePostAdapter(postResponse);
        hideRefreshSpinner();
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void hideLoading() {
        mLoaderPostMkLoader.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onRefresh() {
        getPosts();
    }


    private void configureActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setTitle("Postagens");
    }

    private void getPosts() {
        new PostService(this).getPosts("", "");
    }

    private void hideRefreshSpinner() {
        if (mPostSwipeRefreshLayout.isRefreshing()) {
            mPostSwipeRefreshLayout.setRefreshing(false);
        }
    }

    private void configureBottomBar() {
        AHBottomNavigation bottomNavigation = findViewById(R.id.logged_bottom_navigation);

        AHBottomNavigationItem itemGroup = new AHBottomNavigationItem("Grupos", R.drawable.team, R.color.colorPrimary);
        AHBottomNavigationItem itemMatters = new AHBottomNavigationItem("Materias", R.drawable.book, R.color.colorPrimary);
        AHBottomNavigationItem itemPost = new AHBottomNavigationItem("Postagens", R.drawable.news, R.color.colorPrimary);
        AHBottomNavigationItem itemProfile = new AHBottomNavigationItem("Perfil", R.drawable.user, R.color.colorPrimary);
        AHBottomNavigationItem itemMenu = new AHBottomNavigationItem("Menu", R.drawable.menu, R.color.colorPrimary);

        bottomNavigation.addItem(itemGroup);
        bottomNavigation.addItem(itemMatters);
        bottomNavigation.addItem(itemPost);
        bottomNavigation.addItem(itemProfile);
        bottomNavigation.addItem(itemMenu);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setCurrentItem(POST_POSITION);


        bottomNavigation.setOnTabSelectedListener((position, wasSelected) -> {
            //TODO Colocar troca de fragment

            return true;
        });
    }

    private void configureListeners() {
        mPostSwipeRefreshLayout.setOnRefreshListener(this);
    }


    private void configurePostAdapter(List<PostResponse> postResponse) {
        PostAdapter postAdapter = new PostAdapter(postResponse, this);
        mPostRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter.notifyDataSetChanged();
        mPostRecyclerView.setAdapter(postAdapter);
    }
}
