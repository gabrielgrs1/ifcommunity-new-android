package ifcommunity.com.br.ifcommunity.service.api.post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostApi {

    @GET("/post/get")
    Call<List<PostResponse>> getPosts(@Query("name") String matterName, @Query("lastPost") String lastPost);
}
