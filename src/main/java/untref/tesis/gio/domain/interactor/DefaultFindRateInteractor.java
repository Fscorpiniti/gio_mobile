package untref.tesis.gio.domain.interactor;

import java.util.concurrent.ExecutorService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.TermDepositInformation;
import untref.tesis.gio.domain.TermDepositRepository;


public class DefaultFindRateInteractor implements FindRateInteractor {

    private TermDepositRepository termDepositRepository;
    private ExecutorService executorService;

    public DefaultFindRateInteractor(TermDepositRepository termDepositRepository, ExecutorService executorService) {
        this.termDepositRepository = termDepositRepository;
        this.executorService = executorService;
    }

    @Override
    public Observable<TermDepositInformation> execute() {
        return termDepositRepository.findTermDepositInformationForCreation()
                .subscribeOn(Schedulers.from(executorService))
                .observeOn(AndroidSchedulers.mainThread());
    }
}
