package untref.tesis.gio.domain.factory;


import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.interactor.DefaultFindTermDepositInteractor;
import untref.tesis.gio.domain.interactor.FindTermDepositInteractor;
import untref.tesis.gio.domain.repository.TermDepositRepository;

public class FindTermDepositInteractorFactory {

    public static final int NUMBER_THREADS = 5;

    public static FindTermDepositInteractor build() {
        return new DefaultFindTermDepositInteractor(buildTermDepositRepository(),
                Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS)), AndroidSchedulers.mainThread());
    }

    private static TermDepositRepository buildTermDepositRepository() {
        return TermDepositRepositoryFactory.build();
    }

}
