package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.request.CreateTermDepositRequest;
import untref.tesis.gio.domain.entity.TermDeposit;

public interface CreateTermDepositInteractor {

    Observable<TermDeposit> execute(CreateTermDepositRequest request);

}
