package untref.tesis.gio.domain;


public class TermDepositDataFactory {

    public TermDepositData build(CreateTermDepositRequest request) {
        return new TermDepositData(request.getOwnerId(), request.getAmount(), request.getDuration());
    }

}
