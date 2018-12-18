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

/**
 * Created by mmarafelli
 * Date: 15/12/18
 * Time: 8:37 PM
 * Project: ifcommunity-new-android
 */
public class MatterAdapter extends RecyclerView.Adapter<MatterAdapter.ViewHolder> {

    private List<String> mMatterResponseNameList;
    private Context mContext;
    private GetPostMatterListener getPostMatterListener;


    public MatterAdapter(List<String> matterResponseNameList, Context mContext, GetPostMatterListener getPostMatterListener) {
        this.mMatterResponseNameList = matterResponseNameList;
        this.mContext = mContext;
        this.getPostMatterListener = getPostMatterListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_matter_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String matterResponseName = mMatterResponseNameList.get(position);

        holder.mMatterTextView.setText(matterResponseName);
    }

    @Override
    public int getItemCount() {
        return mMatterResponseNameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mMatterTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mMatterTextView = itemView.findViewById(R.id.adapter_matter_textview);
            mMatterTextView.setOnClickListener(this);
            mMatterTextView.getRootView().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            getPostMatterListener.callPostFragment(mMatterResponseNameList.get(getAdapterPosition()));
        }
    }
}
