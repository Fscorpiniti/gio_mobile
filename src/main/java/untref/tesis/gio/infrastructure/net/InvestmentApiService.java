package untref.tesis.gio.infrastructure.net;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import untref.tesis.gio.infrastructure.response.InvestmentsResponse;

public interface InvestmentApiService {

    @GET("users/{owner_id}/game/investments")
    Observable<InvestmentsResponse> getAll(@Path("owner_id") Integer ownerId);

    @POST("users/{owner_id}/investments/{investment_id}/purchase")
    Observable<InvestmentsResponse> add(@Path("owner_id") Integer ownerId,
                                        @Path("investment_id")Integer investmentId,
                                        @Header("auth_token") String authToken);

}
