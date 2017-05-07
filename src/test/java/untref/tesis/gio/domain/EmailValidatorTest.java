package untref.tesis.gio.domain;


import org.junit.Test;

import untref.tesis.gio.domain.validator.EmailValidator;
import untref.tesis.gio.presentation.exception.ValidationException;

public class EmailValidatorTest {

    @Test
    public void whenValidateCorrectEmailThenExceptionIsNotThrown() throws ValidationException {
        String correctEmail = "test@test.com";

        new EmailValidator().validate(correctEmail);
    }

    @Test(expected = ValidationException.class)
    public void whenValidateEmailWitoutAtThenExceptionIsThrown() throws ValidationException {
        String emailWithoutAt = "testtest.com";

        new EmailValidator().validate(emailWithoutAt);
    }

    @Test(expected = ValidationException.class)
    public void whenValidateEmailWitoutPointThenExceptionIsThrown() throws ValidationException {
        String emailWithoutPoint = "test@testcom";

        new EmailValidator().validate(emailWithoutPoint);
    }

    @Test(expected = ValidationException.class)
    public void whenValidateEmailWitoutExtensionThenExceptionIsThrown() throws ValidationException {
        String emailWithoutExtension = "test@test.";

        new EmailValidator().validate(emailWithoutExtension);
    }

    @Test(expected = ValidationException.class)
    public void whenValidateEmptyEmailThenExceptionIsThrown() throws ValidationException {
        String emptyEmail = "";

        new EmailValidator().validate(emptyEmail);
    }

}
