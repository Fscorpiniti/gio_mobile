package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import untref.tesis.gio.domain.repository.InvestmentRepository;

public class DefaultForceInvestmentInteractor implements ForceInvestmentInteractor {

    private Scheduler schedulerSubscribeOn;
    private Scheduler schedulerObserveOn;
    private InvestmentRepository investmentRepository;

    public DefaultForceInvestmentInteractor(InvestmentRepository investmentRepository,
                                            Scheduler schedulersubscribeOn, Scheduler schedulerObserveOn) {
        this.investmentRepository = investmentRepository;
        this.schedulerObserveOn = schedulerObserveOn;
        this.schedulerSubscribeOn = schedulersubscribeOn;
    }

    @Override
    public Observable<Double> execute(Integer ownerId, Integer invesmentId, String authToken) {
        return investmentRepository.force(ownerId, invesmentId, authToken)
                .subscribeOn(schedulerSubscribeOn)
                .observeOn(schedulerObserveOn);
    }
}
