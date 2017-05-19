package untref.tesis.gio.domain.factory;


import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.interactor.CreateInvestmentInteractor;
import untref.tesis.gio.domain.interactor.DefaultCreateInvestmentInteractor;
import untref.tesis.gio.domain.repository.InvestmentRepository;

public class DefaultCreateInvestmentInteractorFactory {

    private static final int NUMBER_THREADS = 5;

    public static CreateInvestmentInteractor build() {
        return new DefaultCreateInvestmentInteractor(buildInvestmentRepository(),
                Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS)), AndroidSchedulers.mainThread());
    }

    private static InvestmentRepository buildInvestmentRepository() {
        return InvestmentRepositoryFactory.build();
    }
}
