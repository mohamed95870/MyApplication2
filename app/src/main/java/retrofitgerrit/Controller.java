package retrofitgerrit;


import java.util.List;

import com.github.mohamed9555.MainActivity;
import com.github.mohamed9555.MapFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Controller implements Callback<List<Countries>> {

    static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    private final MapFragment mapFragment;


    public Controller(MapFragment mapFragment) {
        this.mapFragment = mapFragment;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);

        Call<List<Countries>> call = gerritAPI.loadChanges("status:open");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
        if(response.isSuccessful()) {
            List<Countries> countriesList = response.body();
            mapFragment.displayCountriesList(countriesList);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Countries>> call, Throwable t) {
        t.printStackTrace();
    }
}