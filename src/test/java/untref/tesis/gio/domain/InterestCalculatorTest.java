package untref.tesis.gio.domain;


import junit.framework.Assert;

import org.junit.Test;

import untref.tesis.gio.presentation.domain.InterestCalculator;

public class InterestCalculatorTest {

    public static final int ONE_MONTH = 1;
    public static final int TWO_MONTHS = 2;
    public static final int THREE_MONTHS = 3;
    public static final int SIX_MONTHS = 6;
    public static final int TWELVE_MONTHS = 12;
    private InterestCalculator calculator;
    private Double interestResult;

    @Test
    public void whenCalculateInterestForOneMonthThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(ONE_MONTH);

        Double expectedInterest = new Double(10);
        thenResultIs(expectedInterest);
    }

    @Test
    public void whenCalculateInterestForTwoMonthsThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(TWO_MONTHS);

        Double expectedInterest = new Double(20);
        thenResultIs(expectedInterest);
    }

    @Test
    public void whenCalculateInterestForThreeMonthsThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(THREE_MONTHS);

        Double expectedInterest = new Double(30);
        thenResultIs(expectedInterest);
    }

    @Test
    public void whenCalculateInterestForSixMonthsThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(SIX_MONTHS);

        Double expectedInterest = new Double(60);
        thenResultIs(expectedInterest);
    }

    @Test
    public void whenCalculateInterestForTwelveMonthsThenResultIsValid() {
        givenNewCalculator();

        whenCalculateInterestFor(TWELVE_MONTHS);

        Double expectedInterest = new Double(120);
        thenResultIs(expectedInterest);
    }

    private void thenResultIs(Double expectedInterest) {
        Assert.assertEquals(expectedInterest, interestResult);
    }

    private void whenCalculateInterestFor(int durationInMonths) {
        Double amount = new Double(100);
        Double rate = new Double(10);
        interestResult = calculator.calculate(amount, rate, durationInMonths);
    }

    private void givenNewCalculator() {
        this.calculator = new InterestCalculator();
    }

}
