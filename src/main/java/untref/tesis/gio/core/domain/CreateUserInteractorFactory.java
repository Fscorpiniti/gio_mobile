package untref.tesis.gio.core.domain;

import java.util.concurrent.Executors;

import untref.tesis.gio.core.interactor.CreateUserInteractor;
import untref.tesis.gio.core.interactor.DefaultCreateUserInteractor;

public class CreateUserInteractorFactory {

    public static CreateUserInteractor build() {
        return new DefaultCreateUserInteractor(buildUserRepository(), Executors.newFixedThreadPool(5));
    }

    private static UserRepository buildUserRepository() {
        return UserRepositoryFactory.build();
    }

}
