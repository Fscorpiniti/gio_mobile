package untref.tesis.gio.domain.factory;


import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.interactor.DefaultGetAllInvestmentInteractor;
import untref.tesis.gio.domain.interactor.GetAllInvestmentInteractor;
import untref.tesis.gio.domain.repository.InvestmentRepository;

public class DefaultGetAllInvestmentInteractorFactory {

    private static final int NUMBER_THREADS = 5;

    public static GetAllInvestmentInteractor build() {
        return new DefaultGetAllInvestmentInteractor(buildInvestmentRepository(),
                Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS)), AndroidSchedulers.mainThread());
    }

    private static InvestmentRepository buildInvestmentRepository() {
        return InvestmentRepositoryFactory.build();
    }

}
