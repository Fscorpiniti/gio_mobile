package untref.tesis.gio.app.domain;

import untref.tesis.gio.app.activity.LoginActivity;
import untref.tesis.gio.core.domain.LoginInteractorFactory;
import untref.tesis.gio.core.interactor.LoginInteractor;
import untref.tesis.gio.app.presenter.DefaultLoginPresenter;
import untref.tesis.gio.app.presenter.LoginPresenter;

public class LoginPresenterFactory {

    public static LoginPresenter createPresenter(LoginActivity loginActivity) {
        return new DefaultLoginPresenter(loginActivity, buildLoginInteractor());
    }

    private static LoginInteractor buildLoginInteractor() {
        return LoginInteractorFactory.createInteractor();
    }

}