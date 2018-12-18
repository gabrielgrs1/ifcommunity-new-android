package ifcommunity.com.br.ifcommunity.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuyenmonkey.mkloader.MKLoader;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.post.PostResponse;
import ifcommunity.com.br.ifcommunity.service.api.post.PostService;
import ifcommunity.com.br.ifcommunity.ui.adapter.GetPostMatterListener;
import ifcommunity.com.br.ifcommunity.ui.adapter.PostAdapter;

/**
 * Created by gabrielgrs
 * Date: 17/12/18
 * Time: 7:34 PM
 * Project: ifcommunity-new-android
 */
public class PostFragment extends Fragment implements PostService.PostServiceListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.logged_post_recyclerview)
    RecyclerView mPostRecyclerView;

    @BindView(R.id.logged_loading_mkloader)
    MKLoader mLoaderPostMkLoader;

    @BindView(R.id.logged_post_swiperefreshlayout)
    SwipeRefreshLayout mPostSwipeRefreshLayout;

    private String matterName = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.bind(this, view);
        init();
        getExtras();
        return view;
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
        getPosts(matterName);
    }

    private void hideRefreshSpinner() {
        if (mPostSwipeRefreshLayout.isRefreshing()) {
            mPostSwipeRefreshLayout.setRefreshing(false);
        }
    }

    private void getPosts(String matterName) {
        new PostService(this).getPosts(matterName, "");
    }


    private void configureRefreshLayout() {
        mPostSwipeRefreshLayout.setColorScheme(R.color.colorPrimary);
    }

    private void configureListeners() {
        mPostSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private void configurePostAdapter(List<PostResponse> postResponse) {
        if (getActivity() != null) {
            PostAdapter postAdapter = new PostAdapter(postResponse, getActivity().getApplicationContext());
            mPostRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
            postAdapter.notifyDataSetChanged();
            mPostRecyclerView.setAdapter(postAdapter);
        }
    }

    private void init() {
        configureRefreshLayout();
        configureListeners();
    }

    private void getExtras() {
        Bundle bundle = getArguments();

        if (bundle != null) {
            matterName = bundle.getString("matter");
        }
        getPosts(matterName);
    }
}
