package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import untref.tesis.gio.domain.request.CreateTermDepositRequest;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.factory.TermDepositDataFactory;
import untref.tesis.gio.domain.repository.TermDepositRepository;


public class DefaultCreateTermDepositInteractor implements CreateTermDepositInteractor {

    private TermDepositRepository termDepositRepository;
    private Scheduler schedulerSubscribeOn;
    private Scheduler schedulerObserveOn;

    public DefaultCreateTermDepositInteractor(TermDepositRepository termDepositRepository,
                                              Scheduler schedulersubscribeOn, Scheduler schedulerObserveOn) {
        this.termDepositRepository = termDepositRepository;
        this.schedulerObserveOn = schedulerObserveOn;
        this.schedulerSubscribeOn = schedulersubscribeOn;
    }

    @Override
    public Observable<TermDeposit> execute(CreateTermDepositRequest request, String authToken) {
        return termDepositRepository.add(new TermDepositDataFactory().build(request), authToken)
                .subscribeOn(schedulerSubscribeOn)
                .observeOn(schedulerObserveOn);
    }

}
