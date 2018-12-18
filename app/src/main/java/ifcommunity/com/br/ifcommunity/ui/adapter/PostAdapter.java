package ifcommunity.com.br.ifcommunity.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import ifcommunity.com.br.ifcommunity.R;
import ifcommunity.com.br.ifcommunity.service.api.post.PostResponse;

/**
 * Created by gabrielgrs
 * Date: 07/12/18
 * Time: 8:37 PM
 * Project: ifcommunity-new-android
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<PostResponse> mPostList;
    private Context mContext;

    public PostAdapter(List<PostResponse> mPostList, Context mContext) {
        this.mPostList = mPostList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_post_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostResponse postResponse = mPostList.get(position);

        holder.mTitleTextView.setText(postResponse.getTitle());
        holder.mAuthorTextView.setText(postResponse.getAuthorName());
        holder.mMatterDateTextView.setText(postResponse.getRegisterDate());

//        String  base64String = postResponse.getHashPhotoAuthor();
//        base64String  = base64String.replace("data:image/jpeg;base64,", "");
//        byte[] decodedString = Base64.decode(base64String , Base64.DEFAULT);
//        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//        holder.mAuthorCircleImageView.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private TextView mMatterDateTextView;
        private CircleImageView mAuthorCircleImageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mAuthorCircleImageView = itemView.findViewById(R.id.adapter_author_image_circleimageview);
            mTitleTextView = itemView.findViewById(R.id.adapter_post_title_textview);
            mAuthorTextView = itemView.findViewById(R.id.adapter_post_author_textview);
            mMatterDateTextView = itemView.findViewById(R.id.adapter_post_date_textview);
        }

    }
}
