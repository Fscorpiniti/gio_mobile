package untref.tesis.gio.domain.interactor;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import untref.tesis.gio.domain.entity.Investment;
import untref.tesis.gio.domain.repository.InvestmentRepository;


public class DefaultGetAllInvestmentInteractor implements GetAllInvestmentInteractor {

    private InvestmentRepository investmentRepository;
    private Scheduler schedulerSubscribeOn;
    private Scheduler schedulerObserveOn;

    public DefaultGetAllInvestmentInteractor(InvestmentRepository investmentRepository,
                                             Scheduler schedulersubscribeOn, Scheduler schedulerObserveOn) {
        this.investmentRepository = investmentRepository;
        this.schedulerObserveOn = schedulerObserveOn;
        this.schedulerSubscribeOn = schedulersubscribeOn;
    }

    @Override
    public Observable<List<Investment>> execute(Integer ownerId) {
        return investmentRepository.getAll(ownerId).subscribeOn(schedulerSubscribeOn)
                .observeOn(schedulerObserveOn);
    }
}
