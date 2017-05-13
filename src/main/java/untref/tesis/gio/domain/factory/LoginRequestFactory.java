package untref.tesis.gio.domain.factory;

import untref.tesis.gio.domain.request.LoginRequest;
import untref.tesis.gio.presentation.checker.FieldChecker;
import untref.tesis.gio.presentation.exception.ValidationException;

public class LoginRequestFactory {

    private FieldChecker emailChecker;
    private FieldChecker passwordChecker;

    public LoginRequestFactory(FieldChecker emailChecker, FieldChecker passwordChecker) {
        this.emailChecker = emailChecker;
        this.passwordChecker = passwordChecker;
    }

    public LoginRequest build(String email, String password) throws ValidationException {
        emailChecker.check(email);
        passwordChecker.check(password);
        return new LoginRequest(email, password);
    }

}
