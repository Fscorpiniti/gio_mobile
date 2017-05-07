package untref.tesis.gio.domain.entity;


import java.util.HashMap;
import java.util.Map;

public class TermDepositInformation {

    private static final int MONTH = 30;
    private static final int BIMONTH = 60;
    private static final int QUARTER = 90;
    private static final int SEMI_ANNUAL = 180;
    private static final int ANNUAL = 360;
    private static final int ONE_MONTH = 1;
    private static final int TWO_MONTH = 2;
    private static final int THREE_MONTH = 3;
    private static final int SIX_MONTH = 6;
    private static final int TWELVE_MONTH = 12;

    private Double monthlyRate;
    private Double biMonthlyRate;
    private Double quarterlyRate;
    private Double semiAnnualRate;
    private Double annualRate;

    public TermDepositInformation(Double monthlyRate, Double biMonthlyRate, Double quarterlyRate, Double semiAnnualRate, Double annualRate) {
        this.monthlyRate = monthlyRate;
        this.biMonthlyRate = biMonthlyRate;
        this.quarterlyRate = quarterlyRate;
        this.semiAnnualRate = semiAnnualRate;
        this.annualRate = annualRate;
    }

    public Double getMonthlyRate() {
            return monthlyRate;
        }

    public Double getBiMonthlyRate() {
            return biMonthlyRate;
        }

    public Double getQuarterlyRate() {
            return quarterlyRate;
        }

    public Double getSemiAnnualRate() {
            return semiAnnualRate;
        }

    public Double getAnnualRate() {
            return annualRate;
        }

    public Double findRateByDuration(Integer duration) {
        Map<Integer, Double> rateByDuration = new HashMap<>();
        rateByDuration.put(MONTH, getMonthlyRate());
        rateByDuration.put(BIMONTH, getBiMonthlyRate());
        rateByDuration.put(QUARTER, getQuarterlyRate());
        rateByDuration.put(SEMI_ANNUAL, getSemiAnnualRate());
        rateByDuration.put(ANNUAL, getAnnualRate());

        return rateByDuration.get(duration);
    }

    public Integer findAmountOfMonths(Integer duration) {
        Map<Integer, Integer> amountOfMonthsByDuration = new HashMap<>();
        amountOfMonthsByDuration.put(MONTH, ONE_MONTH);
        amountOfMonthsByDuration.put(BIMONTH, TWO_MONTH);
        amountOfMonthsByDuration.put(QUARTER, THREE_MONTH);
        amountOfMonthsByDuration.put(SEMI_ANNUAL, SIX_MONTH);
        amountOfMonthsByDuration.put(ANNUAL, TWELVE_MONTH);

        return amountOfMonthsByDuration.get(duration);
    }
}
