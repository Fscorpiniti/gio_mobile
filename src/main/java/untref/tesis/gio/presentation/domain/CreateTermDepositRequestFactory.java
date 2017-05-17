package untref.tesis.gio.presentation.domain;

import untref.tesis.gio.domain.request.CreateTermDepositRequest;
import untref.tesis.gio.presentation.exception.ValidationException;

public class CreateTermDepositRequestFactory {

    public static final Double MIN_VALUE = new Double(0);

    public CreateTermDepositRequest build(Integer ownerId, Double amount, Integer duration, Double rate)
            throws ValidationException {

        validate(ownerId, amount, duration, rate);
        return new CreateTermDepositRequest(ownerId, amount, duration, rate);
    }

    private void validate(Integer ownerId, Double amount, Integer duration, Double rate) throws ValidationException {
        validate(ownerId.doubleValue(), "Owner id es invalido");
        validate(amount, "Cantidad es invalido");
        validate(duration.doubleValue(), "Duracion es invalida");
        validate(rate, "Porcenaje es invalido");
    }

    private void validate(Double value, String message) throws ValidationException {
        if (value == null || value <= MIN_VALUE) {
            throw new ValidationException(message);
        }
    }

}
