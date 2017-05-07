package untref.tesis.gio.domain.factory;


import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.interactor.CreateTermDepositInteractor;
import untref.tesis.gio.domain.interactor.DefaultCreateTermDepositInteractor;

public class CreateTermDepositInteractorFactory {

    public static final int NUMBER_THREADS = 5;

    public static CreateTermDepositInteractor build() {
        return new DefaultCreateTermDepositInteractor(TermDepositRepositoryFactory.build(),
                Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS)), AndroidSchedulers.mainThread());
    }
}
