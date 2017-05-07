package untref.tesis.gio.domain.interactor;

import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.CreateTermDepositRequest;
import untref.tesis.gio.domain.TermDeposit;
import untref.tesis.gio.domain.TermDepositData;
import untref.tesis.gio.domain.TermDepositDataFactory;
import untref.tesis.gio.domain.TermDepositRepository;


public class DefaultCreateTermDepositInteractor implements CreateTermDepositInteractor {

    private TermDepositRepository termDepositRepository;
    private Scheduler schedulersubscribeOn;
    private Scheduler schedulerObserveOn;

    public DefaultCreateTermDepositInteractor(TermDepositRepository termDepositRepository,
                                              Scheduler schedulersubscribeOn, Scheduler schedulerObserveOn) {
        this.termDepositRepository = termDepositRepository;
        this.schedulerObserveOn = schedulerObserveOn;
        this.schedulersubscribeOn = schedulersubscribeOn;
    }

    @Override
    public Observable<TermDeposit> execute(CreateTermDepositRequest request) {
        return termDepositRepository.add(new TermDepositDataFactory().build(request))
                .subscribeOn(schedulersubscribeOn)
                .observeOn(schedulerObserveOn);
    }

}
