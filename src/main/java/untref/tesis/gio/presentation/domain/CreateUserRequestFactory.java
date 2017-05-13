package untref.tesis.gio.presentation.domain;

import untref.tesis.gio.domain.request.CreateUserRequest;
import untref.tesis.gio.presentation.checker.EmailChecker;
import untref.tesis.gio.presentation.checker.FieldChecker;
import untref.tesis.gio.presentation.checker.NameChecker;
import untref.tesis.gio.presentation.checker.PasswordChecker;
import untref.tesis.gio.presentation.exception.ValidationException;

public class CreateUserRequestFactory {

    private FieldChecker emailChecker;
    private FieldChecker passwordChecker;
    private FieldChecker nameChecker;

    public CreateUserRequestFactory(FieldChecker emailChecker, FieldChecker passwordChecker,
                                    FieldChecker nameChecker) {
        this.emailChecker = emailChecker;
        this.passwordChecker = passwordChecker;
        this.nameChecker = nameChecker;
    }

    public CreateUserRequest build(String email, String password, String name)
            throws ValidationException {
        emailChecker.check(email);
        passwordChecker.check(password);
        nameChecker.check(name);
        return new CreateUserRequest(email, password, name);
    }

}
