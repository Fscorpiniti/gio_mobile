package untref.tesis.gio.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import untref.tesis.gio.domain.TermDepositData;
import untref.tesis.gio.infrastructure.TermDepositInformationResponse;
import untref.tesis.gio.infrastructure.TermDepositResponse;

public interface TermDepositApiService {

    @GET("deposits")
    Observable<TermDepositInformationResponse> findTermDepositInformationForCreation();

    @POST("users/{owner_id}/deposits")
    Observable<TermDepositResponse> add(@Path("owner_id") Integer ownerId, @Body TermDepositData
            termDepositData);

}
