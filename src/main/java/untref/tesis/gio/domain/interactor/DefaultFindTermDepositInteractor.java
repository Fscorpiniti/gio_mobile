package untref.tesis.gio.domain.interactor;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.repository.TermDepositRepository;


public class DefaultFindTermDepositInteractor implements FindTermDepositInteractor {

    private TermDepositRepository termDepositRepository;
    private Scheduler schedulerSubscribeOn;
    private Scheduler schedulerObserveOn;

    public DefaultFindTermDepositInteractor(TermDepositRepository termDepositRepository,
                                            Scheduler schedulersubscribeOn,
                                            Scheduler schedulerObserveOn) {
        this.termDepositRepository = termDepositRepository;
        this.schedulerObserveOn = schedulerObserveOn;
        this.schedulerSubscribeOn = schedulersubscribeOn;
    }

    @Override
    public Observable<List<TermDeposit>> findByOwner(Integer ownerId, String authToken) {
        return termDepositRepository.findByOwner(ownerId, authToken)
                .subscribeOn(schedulerSubscribeOn)
                .observeOn(schedulerObserveOn);
    }

}
