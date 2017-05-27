package untref.tesis.gio.presentation.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator {

    private static final int MAX_PERCENTAGE = 100;
    private static final int AMOUNT_DAYS_YEAR = 365;
    private static final int SCALE = 2;

    public Double calculate(Double amount, Double rate, Integer duration) {
        double interest = (amount * rate * duration) / (MAX_PERCENTAGE * AMOUNT_DAYS_YEAR);
        return new BigDecimal(interest).setScale(SCALE, RoundingMode.HALF_UP).doubleValue();
    }

}
