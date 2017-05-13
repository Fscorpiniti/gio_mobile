package untref.tesis.gio.presentation.checker;


import org.apache.commons.lang3.StringUtils;

import untref.tesis.gio.presentation.exception.ValidationException;

public class NameChecker implements FieldChecker {

    public void check(String name) throws ValidationException {
        if (StringUtils.isBlank(name)) {
            throw new ValidationException("El nombre es obligatorio");
        }
    }
}
