package untref.tesis.gio.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import untref.tesis.gio.domain.data.TermDepositData;
import untref.tesis.gio.infrastructure.response.TermDepositInformationResponse;
import untref.tesis.gio.infrastructure.response.TermDepositResponse;
import untref.tesis.gio.infrastructure.response.TermDepositResponses;

public interface TermDepositApiService {

    @GET("deposits")
    Observable<TermDepositInformationResponse> findTermDepositInformationForCreation();

    @POST("users/{owner_id}/deposits")
    Observable<TermDepositResponse> add(@Path("owner_id") Integer ownerId, @Body TermDepositData
            termDepositData, @Header("auth_token") String authToken);

    @GET("users/{owner_id}/deposits")
    Observable<TermDepositResponses> findByOwner(@Path("owner_id") Integer ownerId,
                                                 @Header("auth_token") String authToken);

    @DELETE("users/{owner_id}/deposits/{term_deposit_id}")
    Observable<TermDepositResponse> force(@Path("owner_id") Integer ownerId,
                                          @Path("term_deposit_id") Integer termDepositId,
                                          @Header("auth_token") String authToken);
}
