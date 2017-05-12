package untref.tesis.gio.domain.entity;

import java.util.Date;

public class TermDeposit {

    private Double amount;
    private Double rate;
    private TermDepositStatus status;
    private Date expiration;

    public TermDeposit(Double amount, Double rate, TermDepositStatus status,
                       Date expiration) {
        this.amount = amount;
        this.rate = rate;
        this.status = status;
        this.expiration = expiration;
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

    public Date getExpiration() {
        return expiration;
    }
}
