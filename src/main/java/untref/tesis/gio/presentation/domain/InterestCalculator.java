package untref.tesis.gio.presentation.domain;

public class InterestCalculator {

    private static final int MAX_PERCENTAGE = 100;

    public Double calculate(Double amount, Double rate, Integer durationInMonths) {
        return amount * rate * durationInMonths / MAX_PERCENTAGE;
    }

}
