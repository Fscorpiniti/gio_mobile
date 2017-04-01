package untref.tesis.gio.infrastructure.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ApiService {

    static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://localhost:8080/api")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
