package untref.tesis.gio.infrastructure.net;


import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import untref.tesis.gio.infrastructure.response.InvestmentsResponse;

public interface InvestmentApiService {

    @GET("users/{owner_id}/games/investments")
    Observable<InvestmentsResponse> getAll(@Path("owner_id") Integer ownerId);

    @POST("users/{owner_id}/investments/{investment_id}/purchases")
    Observable<InvestmentsResponse> add(@Path("owner_id") Integer ownerId,
                                        @Path("investment_id")Integer investmentId,
                                        @Header("auth_token") String authToken);

    @GET("users/{owner_id}/investments")
    Observable<InvestmentsResponse> findByOwnerId(@Path("owner_id") Integer ownerId,
                                                  @Header("auth_token") String authToken);


    @DELETE("users/{owner_id}/investments/{investment_id}/purchases")
    Observable<Double> force(@Path("owner_id") Integer ownerId,
                             @Path("investment_id")Integer investmentId,
                             @Header("auth_token") String authToken);
}
