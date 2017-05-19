package untref.tesis.gio.domain.entity;

import java.util.Date;

public class TermDeposit {

    private Integer id;
    private Double amount;
    private Double rate;
    private TermDepositStatus status;
    private Date expiration;

    public TermDeposit(Integer id, Double amount, Double rate, TermDepositStatus status,
                       Date expiration) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public Double calculateValueToBelieve() {
        return getAmount() + calculateInterest();
    }

    private double calculateInterest() {
        return getAmount() * getRate() / 100;
    }
}
