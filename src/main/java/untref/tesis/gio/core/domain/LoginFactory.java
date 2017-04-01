package untref.tesis.gio.core.domain;

import untref.tesis.gio.app.activity.LoginActivity;
import untref.tesis.gio.core.interactor.DefaultLoginInteractor;
import untref.tesis.gio.core.interactor.LoginInteractor;
import untref.tesis.gio.app.presenter.DefaultLoginPresenter;
import untref.tesis.gio.app.presenter.LoginPresenter;
import untref.tesis.gio.infrastructure.repository.DefaultLoginRepository;

public class LoginFactory {

    public static LoginPresenter createPresenter(LoginActivity loginActivity) {
        return new DefaultLoginPresenter(loginActivity, buildLoginInteractor());
    }

    private static LoginInteractor buildLoginInteractor() {
        return new DefaultLoginInteractor(buildLoginRepository());
    }

    private static LoginRepository buildLoginRepository() {
        return new DefaultLoginRepository();
    }

}