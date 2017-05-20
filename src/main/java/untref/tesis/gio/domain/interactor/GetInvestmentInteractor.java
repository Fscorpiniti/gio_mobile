package untref.tesis.gio.domain.interactor;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.Investment;

public interface GetInvestmentInteractor {

    Observable<List<Investment>> getAllForGame(Integer ownerId);

    Observable<List<Investment>> findByOwnerId(Integer ownerId, String authToken);
}
