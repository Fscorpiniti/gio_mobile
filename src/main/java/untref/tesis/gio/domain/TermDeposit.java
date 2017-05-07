package untref.tesis.gio.domain;

import untref.tesis.gio.infrastructure.TermDepositStatus;

public class TermDeposit {

    private Double amount;
    private Double rate;
    private TermDepositStatus status;

    public TermDeposit(Double amount, Double rate, TermDepositStatus status) {
        this.amount = amount;
        this.rate = rate;
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getRate() {
        return rate;
    }

    public TermDepositStatus getStatus() {
        return status;
    }
}
