package untref.tesis.gio.presentation.checker;


import org.apache.commons.lang3.StringUtils;

import untref.tesis.gio.presentation.exception.ValidationException;

public class PasswordChecker implements FieldChecker {

    public void check(String password) throws ValidationException {
        if (StringUtils.isBlank(password)) {
            throw new ValidationException("El password es obligatorio");
        }
    }

}