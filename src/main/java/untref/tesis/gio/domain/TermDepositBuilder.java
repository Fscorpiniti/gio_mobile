package untref.tesis.gio.domain;


import com.google.common.base.Preconditions;

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
        this.validate();
        return new TermDeposit(amount, rate, status);
    }

    private void validate() {
        Preconditions.checkNotNull(amount, "Invalid amount");
        Preconditions.checkNotNull(rate, "Invalid rate");
        Preconditions.checkNotNull(status, "Invalid status");
        Preconditions.checkArgument(amount < 0, "Invalid amount");
        Preconditions.checkArgument(rate < 0, "Invalid rate");
    }

}
