package untref.tesis.gio.core.domain;

import org.apache.commons.lang3.StringUtils;

import untref.tesis.gio.core.exception.ValidationException;

public class LoginRequestFactory {

    public static LoginRequest build(String email, String password) throws ValidationException {
        checkEmail(email);
        checkPassword(password);
        return new LoginRequest(email, password);
    }

    private static void checkPassword(String password) throws ValidationException {
        if (StringUtils.isBlank(password)) {
            throw new ValidationException("Password is required");
        }
    }

    private static void checkEmail(String email) throws ValidationException {
        if (StringUtils.isBlank(email)) {
            throw new ValidationException("Email is required");
        }
    }

}
