package untref.tesis.gio.domain;


import org.junit.Test;

public class EmailValidatorTest {

    @Test
    public void whenValidateCorrectEmailThenExceptionIsNotThrown() {
        String correctEmail = "test@test.com";

        new EmailValidator().validate(correctEmail);
    }

    @Test(expected = EmailInvalidException.class)
    public void whenValidateEmailWitoutAtThenExceptionIsThrown() {
        String emailWithoutAt = "testtest.com";

        new EmailValidator().validate(emailWithoutAt);
    }

    @Test(expected = EmailInvalidException.class)
    public void whenValidateEmailWitoutPointThenExceptionIsThrown() {
        String emailWithoutPoint = "test@testcom";

        new EmailValidator().validate(emailWithoutPoint);
    }

    @Test(expected = EmailInvalidException.class)
    public void whenValidateEmailWitoutExtensionThenExceptionIsThrown() {
        String emailWithoutExtension = "test@test.";

        new EmailValidator().validate(emailWithoutExtension);
    }

    @Test(expected = EmailInvalidException.class)
    public void whenValidateEmptyEmailThenExceptionIsThrown() {
        String emptyEmail = "";

        new EmailValidator().validate(emptyEmail);
    }

}
