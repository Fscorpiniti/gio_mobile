package untref.tesis.gio.domain;


import java.util.HashMap;
import java.util.Map;

public class TermDepositInformation {

    private static final int MONTH = 30;
    private static final int BIMONTH = 60;
    private static final int QUARTER = 90;
    private static final int SEMI_ANNUAL = 180;
    private static final int ANNUAL = 360;

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

    public Double getForDuration(Integer duration) {
        Map<Integer, Double> rateByDuration = new HashMap<>();
        rateByDuration.put(MONTH, getMonthlyRate());
        rateByDuration.put(BIMONTH, getBiMonthlyRate());
        rateByDuration.put(QUARTER, getQuarterlyRate());
        rateByDuration.put(SEMI_ANNUAL, getSemiAnnualRate());
        rateByDuration.put(ANNUAL, getAnnualRate());

        return rateByDuration.get(duration);
    }
}
