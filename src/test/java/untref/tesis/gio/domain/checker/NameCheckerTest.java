package untref.tesis.gio.domain.checker;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import untref.tesis.gio.presentation.checker.NameChecker;
import untref.tesis.gio.presentation.exception.ValidationException;

public class NameCheckerTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void whenNameIsNullThenExceptionisThrown() throws ValidationException {
        String name = null;
        thrown.expect(ValidationException.class);
        new NameChecker().check(name);
    }

    @Test
    public void whenNameIsEmptyThenExceptionisThrown() throws ValidationException {
        String name = "";
        thrown.expect(ValidationException.class);
        new NameChecker().check(name);
    }

}
