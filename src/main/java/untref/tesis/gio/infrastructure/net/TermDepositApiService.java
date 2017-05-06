package untref.tesis.gio.infrastructure.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import untref.tesis.gio.infrastructure.TermDepositInformationResponse;

public interface TermDepositApiService {

    @GET("deposits")
    Observable<TermDepositInformationResponse> findTermDepositInformationForCreation();

}
