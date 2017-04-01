package untref.tesis.gio.app.presenter;

import untref.tesis.gio.app.activity.LoginActivity;
import untref.tesis.gio.core.interactor.LoginInteractor;

public class DefaultLoginPresenter implements LoginPresenter {

    private LoginActivity loginActivity;
    private LoginInteractor loginInteractor;

    public DefaultLoginPresenter(LoginActivity loginActivity, LoginInteractor loginInteractor) {
        this.loginActivity = loginActivity;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void login(String email, String password) {
        this.loginInteractor.login(email, password);
    }

}