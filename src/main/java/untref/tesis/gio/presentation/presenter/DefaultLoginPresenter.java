package untref.tesis.gio.presentation.presenter;

import com.annimon.stream.Optional;

import untref.tesis.gio.domain.validator.EmailValidator;
import untref.tesis.gio.presentation.activity.LoginActivity;
import untref.tesis.gio.domain.request.LoginRequest;
import untref.tesis.gio.domain.factory.LoginRequestFactory;
import untref.tesis.gio.presentation.checker.EmailChecker;
import untref.tesis.gio.presentation.checker.PasswordChecker;
import untref.tesis.gio.presentation.exception.ValidationException;
import untref.tesis.gio.domain.interactor.LoginInteractor;

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
            this.loginInteractor.login(loginRequestOptional.get())
                    .subscribe(userLogged -> loginActivity.successful(userLogged),
                                exception -> handleError(exception));
        }
    }

    private void handleError(Throwable ex) {
        this.loginActivity.notifyError("Email o password incorrecto.");
    }

    private Optional<LoginRequest> buildLoginRequest(String email, String password) {
        try {
            return Optional.of(buildLoginRequestFactory().build(email, password));
        } catch (ValidationException e) {
            this.loginActivity.notifyError(e.getMessage());
            return Optional.empty();
        }
    }

    private LoginRequestFactory buildLoginRequestFactory() {
        return new LoginRequestFactory(buildEmailChecker(), new PasswordChecker());
    }

    private EmailChecker buildEmailChecker() {
        return new EmailChecker(new EmailValidator());
    }

}