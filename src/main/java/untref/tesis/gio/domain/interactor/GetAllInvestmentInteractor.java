package untref.tesis.gio.domain.interactor;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.Investment;

public interface GetAllInvestmentInteractor {

    Observable<List<Investment>> execute();

}
