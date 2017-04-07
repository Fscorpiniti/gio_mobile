package untref.tesis.gio;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import untref.tesis.gio.core.domain.LoginRequest;

import static org.junit.Assert.*;


public class LoginRequestTest {

    private static final String VALID_PASSWORD = "pass";
    private static final String VALID_EMAIL = "test@test.com";
    private static final String EMPTY_STRING = " ";

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void whenCreateLoginRequestWithNullEmailThenExceptionIsThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        new LoginRequest(null, VALID_PASSWORD);
    }

    @Test
    public void whenCreateLoginRequestWithEmptyEmailThenExceptionIsThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        new LoginRequest(EMPTY_STRING, VALID_PASSWORD);
    }

    @Test
    public void whenCreateLoginRequestWithNullPasswordThenExceptionIsThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        new LoginRequest(VALID_EMAIL, null);
    }

    @Test
    public void whenCreateLoginRequestWithEmptyPasswordThenExceptionIsThrown() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        new LoginRequest(EMPTY_STRING, VALID_PASSWORD);
    }

}