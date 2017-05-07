package untref.tesis.gio.domain.factory;


import untref.tesis.gio.domain.request.CreateTermDepositRequest;
import untref.tesis.gio.domain.data.TermDepositData;

public class TermDepositDataFactory {

    public TermDepositData build(CreateTermDepositRequest request) {
        return new TermDepositData(request.getOwnerId(), request.getAmount(), request.getDuration(),
                request.getRate());
    }

}
