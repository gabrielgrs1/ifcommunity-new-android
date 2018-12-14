package ifcommunity.com.br.ifcommunity.service.api.post;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ifcommunity.com.br.ifcommunity.service.api.register.RegisterResponse;

/**
 * Created by gabrielgrs.
 * Date: 11/08/18
 * Time: 15:48
 */
public class PostResponse implements Parcelable {
    @SerializedName("postId")
    private Integer postId;

    @SerializedName("authorId")
    private Integer authorId;

    @SerializedName("authorName")
    private String authorName;

    @SerializedName("matterName")
    private String matterName;

    @SerializedName("title")
    private String title;

    @SerializedName("postText")
    private String postText;

    @SerializedName("programmingLanguage")
    private String programmingLanguage;

    @SerializedName("registerDate")
    private String registerDate;

    @SerializedName("updateDate")
    private String updateDate;

    @SerializedName("likeDeslikePost")
    private List<LikeDeslikeDto> likeDeslikePost;

    @SerializedName("hashPhotoAutor")
    private String hashPhotoAuthor;

    @SerializedName("spam")
    private Boolean spam;


    public PostResponse() {
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getMatterName() {
        return matterName;
    }

    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public List<LikeDeslikeDto> getLikeDeslikePost() {
        return likeDeslikePost;
    }

    public void setLikeDeslikePost(List<LikeDeslikeDto> likeDeslikePost) {
        this.likeDeslikePost = likeDeslikePost;
    }

    public String getHashPhotoAuthor() {
        return hashPhotoAuthor;
    }

    public void setHashPhotoAuthor(String hashPhotoAuthor) {
        this.hashPhotoAuthor = hashPhotoAuthor;
    }

    public Boolean getSpam() {
        return spam;
    }

    public void setSpam(Boolean spam) {
        this.spam = spam;
    }

    protected PostResponse(Parcel in) {
        postId = in.readByte() == 0x00 ? null : in.readInt();
        authorId = in.readByte() == 0x00 ? null : in.readInt();
        authorName = in.readString();
        matterName = in.readString();
        title = in.readString();
        postText = in.readString();
        programmingLanguage = in.readString();
        registerDate = in.readString();
        updateDate = in.readString();
        if (in.readByte() == 0x01) {
            likeDeslikePost = new ArrayList<>();
            in.readList(likeDeslikePost, LikeDeslikeDto.class.getClassLoader());
        } else {
            likeDeslikePost = null;
        }
        hashPhotoAuthor = in.readString();
        byte spamVal = in.readByte();
        spam = spamVal == 0x02 ? null : spamVal != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (postId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(postId);
        }
        if (authorId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(authorId);
        }
        dest.writeString(authorName);
        dest.writeString(matterName);
        dest.writeString(title);
        dest.writeString(postText);
        dest.writeString(programmingLanguage);
        dest.writeString(registerDate);
        dest.writeString(updateDate);
        if (likeDeslikePost == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(likeDeslikePost);
        }
        dest.writeString(hashPhotoAuthor);
        if (spam == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (spam ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PostResponse> CREATOR = new Parcelable.Creator<PostResponse>() {
        @Override
        public PostResponse createFromParcel(Parcel in) {
            return new PostResponse(in);
        }

        @Override
        public PostResponse[] newArray(int size) {
            return new PostResponse[size];
        }
    };
}
