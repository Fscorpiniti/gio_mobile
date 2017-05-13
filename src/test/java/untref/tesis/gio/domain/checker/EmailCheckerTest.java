package untref.tesis.gio.domain.checker;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import untref.tesis.gio.domain.validator.EmailValidator;
import untref.tesis.gio.presentation.checker.EmailChecker;
import untref.tesis.gio.presentation.exception.ValidationException;

public class EmailCheckerTest {

    private static final int NUMBER_OF_INVOCATIONS = 1;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void whenEmailIsNullThenExceptionisThrown() throws ValidationException {
        String email = null;
        thrown.expect(ValidationException.class);
        new EmailChecker(buildEmailValidatorMock()).check(email);
    }

    @Test
    public void whenEmailIsEmptyThenExceptionisThrown() throws ValidationException {
        String email = "";
        thrown.expect(ValidationException.class);
        new EmailChecker(buildEmailValidatorMock()).check(email);
    }

    @Test
    public void whenCheckEmailThenInvokeEmailValidator() throws ValidationException {
        String validEmail = "test@test.com";
        EmailValidator emailValidator = buildEmailValidatorMock();
        new EmailChecker(emailValidator).check(validEmail);
        Mockito.verify(emailValidator, Mockito.times(NUMBER_OF_INVOCATIONS)).validate(validEmail);
    }

    private EmailValidator buildEmailValidatorMock() {
        return Mockito.mock(EmailValidator.class);
    }
}
