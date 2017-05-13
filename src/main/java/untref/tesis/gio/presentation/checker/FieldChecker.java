package untref.tesis.gio.presentation.checker;

import untref.tesis.gio.presentation.exception.ValidationException;

public interface FieldChecker {

    void check(String field) throws ValidationException;

}
