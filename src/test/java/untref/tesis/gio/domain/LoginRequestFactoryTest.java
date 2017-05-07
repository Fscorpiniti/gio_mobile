package untref.tesis.gio.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import untref.tesis.gio.domain.factory.LoginRequestFactory;
import untref.tesis.gio.presentation.exception.ValidationException;


public class LoginRequestFactoryTest {

    private static final String VALID_PASSWORD = "pass";
    private static final String VALID_EMAIL = "test@test.com";
    private static final String EMPTY_STRING = " ";

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void whenCreateLoginRequestWithNullEmailThenExceptionIsThrown() throws ValidationException {
        thrown.expect(ValidationException.class);
        LoginRequestFactory.build(null, VALID_PASSWORD);
    }

    @Test
    public void whenCreateLoginRequestWithEmptyEmailThenExceptionIsThrown() throws ValidationException {
        thrown.expect(ValidationException.class);
        LoginRequestFactory.build(EMPTY_STRING, VALID_PASSWORD);
    }

    @Test
    public void whenCreateLoginRequestWithNullPasswordThenExceptionIsThrown() throws ValidationException {
        thrown.expect(ValidationException.class);
        LoginRequestFactory.build(VALID_EMAIL, null);
    }

    @Test
    public void whenCreateLoginRequestWithEmptyPasswordThenExceptionIsThrown() throws ValidationException {
        thrown.expect(ValidationException.class);
        LoginRequestFactory.build(VALID_EMAIL, EMPTY_STRING);
    }

}