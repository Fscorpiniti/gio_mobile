package untref.tesis.gio.domain.factory;


import com.google.common.base.Preconditions;

import java.util.Date;

import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.entity.TermDepositStatus;

public class TermDepositBuilder {

    private Double amount;
    private Double rate;
    private TermDepositStatus status;
    private Date expiration;

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

    public TermDepositBuilder withExpiration(Date expiration) {
        this.expiration = expiration;
        return this;
    }

    public TermDeposit build() {
        this.validate();
        return new TermDeposit(amount, rate, status, expiration);
    }

    private void validate() {
        Preconditions.checkNotNull(amount, "Invalid amount");
        Preconditions.checkNotNull(rate, "Invalid rate");
        Preconditions.checkNotNull(status, "Invalid status");
        Preconditions.checkNotNull(expiration, "Invalid expiration");
        Preconditions.checkArgument(amount >= 0, "Invalid amount");
        Preconditions.checkArgument(rate >= 0, "Invalid rate");
    }

}
