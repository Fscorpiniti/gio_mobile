package untref.tesis.gio.domain.interactor;


import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.Investment;

public interface CreateInvestmentInteractor {

    Observable<List<Investment>> execute(Integer ownerId, Integer investmentId, String authToken);

}
