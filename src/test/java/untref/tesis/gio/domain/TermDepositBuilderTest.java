package untref.tesis.gio.domain;


import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

import untref.tesis.gio.domain.factory.TermDepositBuilder;
import untref.tesis.gio.domain.entity.TermDepositStatus;

public class TermDepositBuilderTest {

    public static final int VALID_DAYS = 30;

    @Test(expected = NullPointerException.class)
    public void whenCreateTermDepositWithoutAmountThenExceptionIsThrown() {
        Double amount = null;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = 15.0;
        Date expiration = new DateTime().plusDays(VALID_DAYS).toDate();
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate)
            .withExpiration(expiration).build();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateTermDepositWithoutTermDepositStatusThenExceptionIsThrown() {
        Double amount = 100.0;
        TermDepositStatus status = null;
        Double rate = 15.0;
        Date expiration = new DateTime().plusDays(VALID_DAYS).toDate();
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate)
                .withExpiration(expiration).build();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateTermDepositWithoutRateThenExceptionIsThrown() {
        Double amount = 100.0;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = null;
        Date expiration = new DateTime().plusDays(VALID_DAYS).toDate();
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate)
                .withExpiration(expiration).build();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateTermDepositWithoutExpirationThenExceptionIsThrown() {
        Double amount = 100.0;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = 15.0;
        Date expiration = null;
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate)
                .withExpiration(expiration).build();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateTermDepositWithoutIdThenExceptionIsThrown() {
        Double amount = 100.0;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = 15.0;
        Integer id = null;
        Date expiration = new DateTime().plusDays(VALID_DAYS).toDate();
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate)
                .withExpiration(expiration).withId(id).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateTermDepositWithAmountLessThanZeroThenExceptionIsThrown() {
        Double amount = -1.0;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = 15.0;
        Integer id = 1;
        Date expiration = new DateTime().plusDays(VALID_DAYS).toDate();
        Integer duration = new Integer(30);
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate)
                .withExpiration(expiration).withId(id).withDuration(duration).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateTermDepositWithRateLessThanZeroThenExceptionIsThrown() {
        Double amount = 100.0;
        TermDepositStatus status = TermDepositStatus.ACTIVE;
        Double rate = -15.0;
        Integer id = 1;
        Date expiration = new DateTime().plusDays(VALID_DAYS).toDate();
        Integer duration = new Integer(30);
        new TermDepositBuilder().withAmount(amount).withStatus(status).withRate(rate)
                .withExpiration(expiration).withId(id).withDuration(duration).build();
    }

}
