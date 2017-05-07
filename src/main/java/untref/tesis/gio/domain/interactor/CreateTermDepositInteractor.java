package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.CreateTermDepositRequest;
import untref.tesis.gio.domain.TermDeposit;

public interface CreateTermDepositInteractor {

    Observable<TermDeposit> execute(CreateTermDepositRequest request);

}
