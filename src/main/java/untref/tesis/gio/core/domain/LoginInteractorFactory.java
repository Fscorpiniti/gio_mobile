package untref.tesis.gio.core.domain;

import untref.tesis.gio.core.interactor.DefaultLoginInteractor;
import untref.tesis.gio.core.interactor.LoginInteractor;
import untref.tesis.gio.infrastructure.domain.LoginRepositoryFactory;

public class LoginInteractorFactory {

    public static LoginInteractor createInteractor() {
        return new DefaultLoginInteractor(buildLoginRepository());
    }

    private static LoginRepository buildLoginRepository() {
        return LoginRepositoryFactory.createRepository();
    }

}
