package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.TermDepositInformation;

public interface FindRateInteractor {

    Observable<TermDepositInformation> execute();

}
