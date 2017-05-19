package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.TermDeposit;

public interface ForceTermDepositInteractor {

    Observable<TermDeposit> force(Integer ownerId, Integer termDepositId, String authToken);

}
