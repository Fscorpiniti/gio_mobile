package untref.tesis.gio.domain;

import java.util.concurrent.Executors;

import untref.tesis.gio.domain.interactor.DefaultLoginInteractor;
import untref.tesis.gio.domain.interactor.LoginInteractor;

public class LoginInteractorFactory {

    public static LoginInteractor build() {
        return new DefaultLoginInteractor(buildLoginRepository(),
                Executors.newFixedThreadPool(5));
    }

    private static LoginRepository buildLoginRepository() {
        return LoginRepositoryFactory.build();
    }

}
