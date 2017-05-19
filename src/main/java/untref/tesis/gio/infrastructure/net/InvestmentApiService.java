package untref.tesis.gio.infrastructure.net;


import io.reactivex.Observable;
import retrofit2.http.GET;
import untref.tesis.gio.infrastructure.response.InvestmentsResponse;

public interface InvestmentApiService {

    @GET("investments")
    Observable<InvestmentsResponse> getAll();

}
