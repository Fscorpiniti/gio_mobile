package untref.tesis.gio.domain.factory;


import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.interactor.DefaultForceInvestmentInteractor;
import untref.tesis.gio.domain.interactor.ForceInvestmentInteractor;
import untref.tesis.gio.domain.repository.InvestmentRepository;

public class DefaultForceInvestmentIntectorFactory {

    private static final int NUMBER_THREADS = 5;

    public static ForceInvestmentInteractor build() {
        return new DefaultForceInvestmentInteractor(buildInvestmentRepository(),
                Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS)), AndroidSchedulers.mainThread());
    }

    private static InvestmentRepository buildInvestmentRepository() {
        return InvestmentRepositoryFactory.build();
    }

}
