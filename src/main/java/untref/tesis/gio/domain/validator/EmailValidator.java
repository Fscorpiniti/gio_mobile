package untref.tesis.gio.domain.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import untref.tesis.gio.presentation.exception.ValidationException;

public class EmailValidator {

    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void validate(String email) throws ValidationException {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);

        if (!matcher.find()) {
            throw new ValidationException("Email is invalid");
        }
    }

}
