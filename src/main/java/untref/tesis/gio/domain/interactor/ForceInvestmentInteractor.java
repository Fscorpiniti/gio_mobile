package untref.tesis.gio.domain.interactor;


import io.reactivex.Observable;

public interface ForceInvestmentInteractor {

    Observable<Double> execute(Integer ownerId, Integer invesmentId, String authToken);

}
