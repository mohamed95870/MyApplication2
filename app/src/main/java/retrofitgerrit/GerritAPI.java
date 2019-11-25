package retrofitgerrit;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

    public interface GerritAPI {

        @GET("all")
        Call<List<Countries>> loadChanges(@Query("q") String status);
    }
