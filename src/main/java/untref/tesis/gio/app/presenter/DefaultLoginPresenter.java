package untref.tesis.gio.app.presenter;

import com.annimon.stream.Optional;

import untref.tesis.gio.app.activity.LoginActivity;
import untref.tesis.gio.core.domain.LoginRequest;
import untref.tesis.gio.core.domain.LoginRequestFactory;
import untref.tesis.gio.core.exception.ValidationException;
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
        Optional<LoginRequest> loginRequestOptional = buildLoginRequest(email, password);

        if (loginRequestOptional.isPresent()) {
            this.loginInteractor.login(loginRequestOptional.get()).subscribe(user -> loginActivity.successful(user));
        }
    }

    private Optional<LoginRequest> buildLoginRequest(String email, String password) {
        try {
            return Optional.of(LoginRequestFactory.build(email, password));
        } catch (ValidationException e) {
            this.loginActivity.handleError(e);
            return Optional.empty();
        }
    }

}