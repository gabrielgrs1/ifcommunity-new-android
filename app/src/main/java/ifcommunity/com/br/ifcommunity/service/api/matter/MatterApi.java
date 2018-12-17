package ifcommunity.com.br.ifcommunity.service.api.matter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MatterApi {

    @GET("/matter")
    Call<List<MatterResponse>> getMatters(@Query("studentId") Integer studentId);
}
