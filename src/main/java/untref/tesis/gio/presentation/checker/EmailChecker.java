package untref.tesis.gio.presentation.checker;

import org.apache.commons.lang3.StringUtils;

import untref.tesis.gio.domain.validator.EmailValidator;
import untref.tesis.gio.presentation.exception.ValidationException;

public class EmailChecker implements FieldChecker {

    private EmailValidator emailValidator;

    public EmailChecker(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    public void check(String email) throws ValidationException {
        if (StringUtils.isBlank(email)) {
            throw new ValidationException("El email es obligatorio");
        }

        emailValidator.validate(email);
    }

}
