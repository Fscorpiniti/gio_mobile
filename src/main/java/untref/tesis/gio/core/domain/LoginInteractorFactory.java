package untref.tesis.gio.core.domain;

import java.util.concurrent.Executors;

import untref.tesis.gio.core.interactor.DefaultLoginInteractor;
import untref.tesis.gio.core.interactor.LoginInteractor;

public class LoginInteractorFactory {

    public static LoginInteractor createInteractor() {
        return new DefaultLoginInteractor(buildLoginRepository(),
                Executors.newFixedThreadPool(5));
    }

    private static LoginRepository buildLoginRepository() {
        return LoginRepositoryFactory.createRepository();
    }

}
