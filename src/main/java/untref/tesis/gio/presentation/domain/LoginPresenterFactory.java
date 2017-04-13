package untref.tesis.gio.presentation.domain;

import untref.tesis.gio.presentation.activity.LoginActivity;
import untref.tesis.gio.domain.LoginInteractorFactory;
import untref.tesis.gio.domain.interactor.LoginInteractor;
import untref.tesis.gio.presentation.presenter.DefaultLoginPresenter;
import untref.tesis.gio.presentation.presenter.LoginPresenter;

public class LoginPresenterFactory {

    public static LoginPresenter build(LoginActivity loginActivity) {
        return new DefaultLoginPresenter(loginActivity, buildLoginInteractor());
    }

    private static LoginInteractor buildLoginInteractor() {
        return LoginInteractorFactory.build();
    }

}