package untref.tesis.gio.domain;


import untref.tesis.gio.infrastructure.TermDepositStatus;

public class TermDepositBuilder {

    private Double amount;
    private Double rate;
    private TermDepositStatus status;

    public TermDepositBuilder withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public TermDepositBuilder withRate(Double rate) {
        this.rate = rate;
        return this;
    }

    public TermDepositBuilder withStatus(TermDepositStatus status) {
        this.status = status;
        return this;
    }

    public TermDeposit build() {
        return new TermDeposit(amount, rate, status);
    }

}
