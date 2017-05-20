package untref.tesis.gio.domain.interactor;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import untref.tesis.gio.domain.entity.Investment;
import untref.tesis.gio.domain.repository.InvestmentRepository;


public class DefaultGetInvestmentInteractor implements GetInvestmentInteractor {

    private InvestmentRepository investmentRepository;
    private Scheduler schedulerSubscribeOn;
    private Scheduler schedulerObserveOn;

    public DefaultGetInvestmentInteractor(InvestmentRepository investmentRepository,
                                          Scheduler schedulersubscribeOn, Scheduler schedulerObserveOn) {
        this.investmentRepository = investmentRepository;
        this.schedulerObserveOn = schedulerObserveOn;
        this.schedulerSubscribeOn = schedulersubscribeOn;
    }

    @Override
    public Observable<List<Investment>> getAllForGame(Integer ownerId) {
        return investmentRepository.getAll(ownerId).subscribeOn(schedulerSubscribeOn)
                .observeOn(schedulerObserveOn);
    }

    @Override
    public Observable<List<Investment>> findByOwnerId(Integer ownerId, String authToken) {
        return investmentRepository.findByOwnerId(ownerId, authToken).subscribeOn(schedulerSubscribeOn)
                .observeOn(schedulerObserveOn);
    }
}
