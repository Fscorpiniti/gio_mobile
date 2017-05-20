package untref.tesis.gio.domain.factory;


import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.interactor.DefaultGetInvestmentInteractor;
import untref.tesis.gio.domain.interactor.GetInvestmentInteractor;
import untref.tesis.gio.domain.repository.InvestmentRepository;

public class DefaultGetAllInvestmentInteractorFactory {

    private static final int NUMBER_THREADS = 5;

    public static GetInvestmentInteractor build() {
        return new DefaultGetInvestmentInteractor(buildInvestmentRepository(),
                Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS)), AndroidSchedulers.mainThread());
    }

    private static InvestmentRepository buildInvestmentRepository() {
        return InvestmentRepositoryFactory.build();
    }

}
