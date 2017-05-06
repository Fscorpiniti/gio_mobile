package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.TermDepositInformation;

public interface FindRateInteractor {

    Observable<TermDepositInformation> execute();

}
