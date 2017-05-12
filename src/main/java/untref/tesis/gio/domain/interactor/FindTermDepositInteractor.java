package untref.tesis.gio.domain.interactor;


import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.TermDeposit;

public interface FindTermDepositInteractor {

    Observable<List<TermDeposit>> findByOwner(Integer ownerId);

}
