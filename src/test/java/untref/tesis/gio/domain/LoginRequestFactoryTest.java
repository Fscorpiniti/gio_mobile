package untref.tesis.gio.domain;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import untref.tesis.gio.domain.factory.LoginRequestFactory;
import untref.tesis.gio.domain.request.LoginRequest;
import untref.tesis.gio.presentation.checker.EmailChecker;
import untref.tesis.gio.presentation.checker.PasswordChecker;
import untref.tesis.gio.presentation.exception.ValidationException;


public class LoginRequestFactoryTest {

    private static final String VALID_PASSWORD = "pass";
    private static final String VALID_EMAIL = "test@test.com";
    private static final int NUMBER_OF_INVOCATIONS = 1;

    private LoginRequest loginRequest;

    @Test
    public void whenCreateLoginRequestThenInvokeEmailChecker() throws ValidationException {
        EmailChecker emailChecker = Mockito.mock(EmailChecker.class);
        PasswordChecker passwordChecker = Mockito.mock(PasswordChecker.class);

        whenBuildLoginRequest(emailChecker, passwordChecker);

        Mockito.verify(emailChecker, Mockito.times(NUMBER_OF_INVOCATIONS)).check(VALID_EMAIL);
    }

    @Test
    public void whenCreateLoginRequestThenInvokePasswordChecker() throws ValidationException {
        EmailChecker emailChecker = Mockito.mock(EmailChecker.class);
        PasswordChecker passwordChecker = Mockito.mock(PasswordChecker.class);

        whenBuildLoginRequest(emailChecker, passwordChecker);

        Mockito.verify(passwordChecker, Mockito.times(NUMBER_OF_INVOCATIONS)).check(VALID_PASSWORD);
    }

    @Test
    public void whenCreateLoginRequestThenResultIsValid() throws ValidationException {
        EmailChecker emailChecker = Mockito.mock(EmailChecker.class);
        PasswordChecker passwordChecker = Mockito.mock(PasswordChecker.class);

        whenBuildLoginRequest(emailChecker, passwordChecker);

        Assert.assertEquals(VALID_EMAIL, loginRequest.getEmail());
        Assert.assertEquals(VALID_PASSWORD, loginRequest.getPassword());
    }

    private void whenBuildLoginRequest(EmailChecker emailChecker, PasswordChecker passwordChecker) throws ValidationException {
        loginRequest = new LoginRequestFactory(emailChecker, passwordChecker).build(VALID_EMAIL, VALID_PASSWORD);
    }

}