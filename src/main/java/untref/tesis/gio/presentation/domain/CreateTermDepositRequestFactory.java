package untref.tesis.gio.presentation.domain;

import untref.tesis.gio.domain.request.CreateTermDepositRequest;
import untref.tesis.gio.presentation.exception.ValidationException;

public class CreateTermDepositRequestFactory {

    public static final int MIN_VALUE = 0;

    public CreateTermDepositRequest build(Integer ownerId, Double amount, Integer duration, Double rate)
            throws ValidationException {

        validate(ownerId, amount, duration, rate);
        return new CreateTermDepositRequest(ownerId, amount, duration, rate);
    }

    private void validate(Integer ownerId, Double amount, Integer duration, Double rate) throws ValidationException {
        validate(ownerId, "Owner id es invalido");
        validate(amount, "Cantidad es invalido");
        validate(duration, "Duracion es invalida");
        validate(rate, "Porcenaje es invalido");
    }

    private void validate(Double value, String message) throws ValidationException {
        if (value == null || value.intValue() <= MIN_VALUE) {
            throw new ValidationException(message);
        }
    }

    private void validate(Integer value, String message) throws ValidationException {
        if (value == null || value <= MIN_VALUE) {
            throw new ValidationException(message);
        }
    }
}
