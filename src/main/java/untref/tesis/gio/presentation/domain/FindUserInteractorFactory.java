package untref.tesis.gio.presentation.domain;


import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.factory.UserRepositoryFactory;
import untref.tesis.gio.domain.interactor.DefaultFindUserInteractor;
import untref.tesis.gio.domain.interactor.FindUserInteractor;
import untref.tesis.gio.domain.repository.UserRepository;

public class FindUserInteractorFactory {

    private static final int NUMBER_THREADS = 5;

    public static FindUserInteractor build() {
        return new DefaultFindUserInteractor(buildUserRepository(), Schedulers
                .from(Executors.newFixedThreadPool(NUMBER_THREADS)), AndroidSchedulers.mainThread());
    }

    private static UserRepository buildUserRepository() {
        return UserRepositoryFactory.build();
    }
}
