package untref.tesis.gio.domain.factory;


import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.interactor.DefaultForceTermDepositInteractor;
import untref.tesis.gio.domain.interactor.ForceTermDepositInteractor;
import untref.tesis.gio.domain.repository.TermDepositRepository;

public class ForceTermDepositInteractorFactory {

    private static final int NUMBER_THREADS = 5;

    public static ForceTermDepositInteractor build() {
        return new DefaultForceTermDepositInteractor(buildTermDepositRepository(),
                Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS)), AndroidSchedulers.mainThread());
    }

    private static TermDepositRepository buildTermDepositRepository() {
        return TermDepositRepositoryFactory.build();
    }

}
