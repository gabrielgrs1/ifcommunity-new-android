package ifcommunity.com.br.ifcommunity.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.matter.MatterResponse;

/**
 * Created by mmarafelli
 * Date: 15/12/18
 * Time: 8:37 PM
 * Project: ifcommunity-new-android
 */
public class MatterAdapter extends RecyclerView.Adapter<MatterAdapter.ViewHolder> {

    private List<MatterResponse> mMatterList;
    private Context mContext;

    public MatterAdapter(List<MatterResponse> mMatterList, Context mContext) {
        this.mMatterList = mMatterList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_matter_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MatterResponse matterResponse = mMatterList.get(position);

        holder.mMatterTextView.setText(matterResponse.getMatterName());

    }

    @Override
    public int getItemCount() {
        return mMatterList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mMatterTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mMatterTextView = itemView.findViewById(R.id.adapter_matter_textview);
        }

    }
}
