package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.repository.TermDepositRepository;

public class DefaultForceTermDepositInteractor implements ForceTermDepositInteractor {

    private TermDepositRepository termDepositRepository;
    private Scheduler schedulerSubscribeOn;
    private Scheduler schedulerObserveOn;

    public DefaultForceTermDepositInteractor(TermDepositRepository termDepositRepository,
                                             Scheduler schedulersubscribeOn, Scheduler schedulerObserveOn) {
        this.termDepositRepository = termDepositRepository;
        this.schedulerObserveOn = schedulerObserveOn;
        this.schedulerSubscribeOn = schedulersubscribeOn;
    }

    @Override
    public Observable<TermDeposit> force(Integer ownerId, Integer termDepositId, String authToken) {
        return termDepositRepository.force(ownerId, termDepositId, authToken).subscribeOn(schedulerSubscribeOn)
                .observeOn(schedulerObserveOn);
    }
}
