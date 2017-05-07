package untref.tesis.gio.domain;


import org.junit.Test;

import untref.tesis.gio.domain.factory.TermDepositBuilder;
import untref.tesis.gio.domain.entity.TermDepositStatus;

public class TermDepositBuilderTest {

    @Test(expected = NullPointerException.class)
    public void whenCreateTermDepositWithoutAmountThenExceptionIsThrown() {
        Double amount = null;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = 15.0;
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate).build();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateTermDepositWithoutTermDepositStatusThenExceptionIsThrown() {
        Double amount = 100.0;
        TermDepositStatus status = null;
        Double rate = 15.0;
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate).build();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateTermDepositWithoutRateThenExceptionIsThrown() {
        Double amount = 100.0;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = null;
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateTermDepositWithAmountLessThanZeroThenExceptionIsThrown() {
        Double amount = -1.0;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = 15.0;
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateTermDepositWithRateLessThanZeroThenExceptionIsThrown() {
        Double amount = 100.0;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = -15.0;
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate).build();
    }

}
