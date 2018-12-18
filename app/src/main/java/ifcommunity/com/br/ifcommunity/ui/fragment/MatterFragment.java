package ifcommunity.com.br.ifcommunity.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tuyenmonkey.mkloader.MKLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.CallbackResponseListener;
import ifcommunity.com.br.ifcommunity.service.api.matter.MatterResponse;
import ifcommunity.com.br.ifcommunity.service.api.matter.MatterService;
import ifcommunity.com.br.ifcommunity.ui.activity.LoggedActivity;
import ifcommunity.com.br.ifcommunity.ui.adapter.GetPostMatterListener;
import ifcommunity.com.br.ifcommunity.ui.adapter.MatterAdapter;
import retrofit2.Response;

/**
 * Created by gabrielgrs
 * Date: 17/12/18
 * Time: 8:06 PM
 * Project: ifcommunity-new-android
 */
public class MatterFragment extends Fragment implements CallbackResponseListener, GetPostMatterListener {

    @BindView(R.id.matter_list_recyclerview)
    RecyclerView mMatterRecyclerView;

    @BindView(R.id.matter_loading_mkloader)
    MKLoader mMatterMkLoader;

    GetPostMatterListener getPostMatterListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matter, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onResponse(Response response) {
        List<String> matterNameResponse = new ArrayList<>();

        if (response.body() != null) {
            for (MatterResponse matter :
                    (List<MatterResponse>) response.body()) {
                matterNameResponse.add(matter.getMatterName());
            }
            Collections.sort(matterNameResponse);
            configureMatterAdapter(matterNameResponse);
        }


    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void hideLoading() {
        mMatterMkLoader.setVisibility(View.GONE);
    }


    @Override
    public void callPostFragment(String matterName) {
        getPostMatterListener.callPostFragment(matterName);
    }

    private void getMatters() {
        new MatterService(this).getMatters();
    }

    private void configureMatterAdapter(List<String> matterResponseName) {
        MatterAdapter matterAdapter = new MatterAdapter(matterResponseName, getActivity().getApplicationContext(), this);
        mMatterRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        matterAdapter.notifyDataSetChanged();
        mMatterRecyclerView.setAdapter(matterAdapter);
    }

    private void init() {
        getMatters();
    }

    public void setGetterPostListener(LoggedActivity activity) {
        getPostMatterListener = activity;
    }
}
