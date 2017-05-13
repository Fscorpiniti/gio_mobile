package untref.tesis.gio.domain.checker;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import untref.tesis.gio.presentation.checker.PasswordChecker;
import untref.tesis.gio.presentation.exception.ValidationException;

public class PasswordCheckerTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void whenPasswordIsNullThenExceptionisThrown() throws ValidationException {
        String password = null;
        thrown.expect(ValidationException.class);
        new PasswordChecker().check(password);
    }

    @Test
    public void whenPasswordIsEmptyThenExceptionisThrown() throws ValidationException {
        String password = "";
        thrown.expect(ValidationException.class);
        new PasswordChecker().check(password);
    }

}
