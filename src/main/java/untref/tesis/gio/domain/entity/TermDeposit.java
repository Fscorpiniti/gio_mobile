package untref.tesis.gio.domain.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class TermDeposit {

    private static final int AMOUNT_DAYS_YEAR = 365;
    private static final int MAX_PERCENTAGE = 100;
    private static final int SCALE = 2;

    private Integer id;
    private Double amount;
    private Double rate;
    private TermDepositStatus status;
    private Date expiration;
    private Integer duration;

    public TermDeposit(Integer id, Double amount, Double rate, TermDepositStatus status,
                       Date expiration, Integer duration) {
        this.id = id;
        this.amount = amount;
        this.rate = rate;
        this.status = status;
        this.expiration = expiration;
        this.duration = duration;
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
        Double finalAmount = getAmount() + calculateInterest();
        return new BigDecimal(finalAmount).setScale(SCALE, RoundingMode.HALF_UP).doubleValue();
    }

    private double calculateInterest() {
        return (getAmount() * getDuration() * getRate()) / (MAX_PERCENTAGE * AMOUNT_DAYS_YEAR);
    }

    public Integer getDuration() {
        return duration;
    }
}
