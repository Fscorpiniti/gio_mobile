package untref.tesis.gio.domain.factory;

import org.apache.commons.lang3.StringUtils;

import untref.tesis.gio.domain.validator.EmailValidator;
import untref.tesis.gio.domain.request.LoginRequest;
import untref.tesis.gio.presentation.exception.ValidationException;

public class LoginRequestFactory {

    public static LoginRequest build(String email, String password) throws ValidationException {
        checkEmail(email);
        checkPassword(password);
        return new LoginRequest(email, password);
    }

    private static void checkPassword(String password) throws ValidationException {
        if (StringUtils.isBlank(password)) {
            throw new ValidationException("El password es obligatorio");
        }
    }

    private static void checkEmail(String email) throws ValidationException {
        if (StringUtils.isBlank(email)) {
            throw new ValidationException("El email es obligatorio");
        }

        new EmailValidator().validate(email);
    }

}
