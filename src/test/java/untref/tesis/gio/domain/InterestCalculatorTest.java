package untref.tesis.gio.domain;


import junit.framework.Assert;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import untref.tesis.gio.presentation.domain.InterestCalculator;

public class InterestCalculatorTest {

    public static final int ONE_MONTH = 30;
    public static final int TWO_MONTHS = 60;
    public static final int THREE_MONTHS = 90;
    public static final int SIX_MONTHS = 180;
    public static final int TWELVE_MONTHS = 365;
    public static final Double AMOUNT = new Double(100);
    public static final Double RATE = new Double(10);
    private InterestCalculator calculator;
    private Double interestResult;
    private static final int SCALE = 2;

    @Test
    public void whenCalculateInterestForOneMonthThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(ONE_MONTH);

        Double expectedInterest = new Double((AMOUNT * RATE * ONE_MONTH) / 36500);
        thenResultIs(expectedInterest);
    }

    @Test
    public void whenCalculateInterestForTwoMonthsThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(TWO_MONTHS);

        Double expectedInterest = new Double((AMOUNT * RATE * TWO_MONTHS) / 36500);
        thenResultIs(expectedInterest);
    }

    @Test
    public void whenCalculateInterestForThreeMonthsThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(THREE_MONTHS);

        Double expectedInterest = new Double((AMOUNT * RATE * THREE_MONTHS) / 36500);
        thenResultIs(expectedInterest);
    }

    @Test
    public void whenCalculateInterestForSixMonthsThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(SIX_MONTHS);

        Double expectedInterest = new Double((AMOUNT * RATE * SIX_MONTHS) / 36500);
        thenResultIs(expectedInterest);
    }

    @Test
    public void whenCalculateInterestForTwelveMonthsThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(TWELVE_MONTHS);

        Double expectedInterest = new Double((AMOUNT * RATE * TWELVE_MONTHS) / 36500);
        thenResultIs(expectedInterest);
    }

    private void thenResultIs(Double expectedInterest) {
        Double scaleExpected = new BigDecimal(expectedInterest).setScale(SCALE, RoundingMode.HALF_UP).doubleValue();
        Assert.assertEquals(scaleExpected, interestResult);
    }

    private void whenCalculateInterestFor(int durationInMonths) {
        interestResult = calculator.calculate(AMOUNT, RATE, durationInMonths);
    }

    private void givenNewCalculator() {
        this.calculator = new InterestCalculator();
    }

}
