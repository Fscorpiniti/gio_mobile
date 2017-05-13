package untref.tesis.gio.domain;


import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import untref.tesis.gio.domain.request.CreateUserRequest;
import untref.tesis.gio.presentation.checker.EmailChecker;
import untref.tesis.gio.presentation.checker.NameChecker;
import untref.tesis.gio.presentation.checker.PasswordChecker;
import untref.tesis.gio.presentation.domain.CreateUserRequestFactory;
import untref.tesis.gio.presentation.exception.ValidationException;

public class CreateUserRequestFactoryTest {

    private static final String VALID_PASSWORD = "pass";
    private static final String VALID_EMAIL = "test@test.com";
    private static final int NUMBER_OF_INVOCATIONS = 1;
    public static final String VALID_NAME = "test";

    @Test
    public void whenCreateUserRequestThenInvokeEmailChecker() throws ValidationException {
        EmailChecker emailChecker = Mockito.mock(EmailChecker.class);
        PasswordChecker passwordChecker = Mockito.mock(PasswordChecker.class);
        NameChecker nameChecker = Mockito.mock(NameChecker.class);

        new CreateUserRequestFactory(emailChecker, passwordChecker, nameChecker).build(VALID_EMAIL,
                VALID_PASSWORD, VALID_NAME);

        Mockito.verify(emailChecker, Mockito.times(NUMBER_OF_INVOCATIONS)).check(VALID_EMAIL);
    }

    @Test
    public void whenCreateUserRequestThenInvokePasswordChecker() throws ValidationException {
        EmailChecker emailChecker = Mockito.mock(EmailChecker.class);
        PasswordChecker passwordChecker = Mockito.mock(PasswordChecker.class);
        NameChecker nameChecker = Mockito.mock(NameChecker.class);

        new CreateUserRequestFactory(emailChecker, passwordChecker, nameChecker).build(VALID_EMAIL,
                VALID_PASSWORD, VALID_NAME);

        Mockito.verify(passwordChecker, Mockito.times(NUMBER_OF_INVOCATIONS)).check(VALID_PASSWORD);
    }

    @Test
    public void whenCreateUserRequestThenInvokeNameChecker() throws ValidationException {
        EmailChecker emailChecker = Mockito.mock(EmailChecker.class);
        PasswordChecker passwordChecker = Mockito.mock(PasswordChecker.class);
        NameChecker nameChecker = Mockito.mock(NameChecker.class);

        new CreateUserRequestFactory(emailChecker, passwordChecker, nameChecker).build(VALID_EMAIL,
                VALID_PASSWORD, VALID_NAME);

        Mockito.verify(nameChecker, Mockito.times(NUMBER_OF_INVOCATIONS)).check(VALID_NAME);
    }

    @Test
    public void whenCreateUserRequestThenResultIsValid() throws ValidationException {
        EmailChecker emailChecker = Mockito.mock(EmailChecker.class);
        PasswordChecker passwordChecker = Mockito.mock(PasswordChecker.class);
        NameChecker nameChecker = Mockito.mock(NameChecker.class);

        CreateUserRequest createUserRequest = new CreateUserRequestFactory(emailChecker, passwordChecker, nameChecker)
                .build(VALID_EMAIL, VALID_PASSWORD, VALID_NAME);

        Assert.assertEquals(VALID_EMAIL, createUserRequest.getEmail());
        Assert.assertEquals(VALID_NAME, createUserRequest.getName());
        Assert.assertEquals(VALID_PASSWORD, createUserRequest.getPassword());
    }
}
