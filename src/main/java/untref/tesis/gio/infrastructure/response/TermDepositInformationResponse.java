package untref.tesis.gio.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class TermDepositInformationResponse {

    @SerializedName("monthly_rate")
    private Double monthlyRate;

    @SerializedName("bi_monthly_rate")
    private Double biMonthlyRate;

    @SerializedName("quarterly_rate")
    private Double quarterlyRate;

    @SerializedName("semi_annual_rate")
    private Double semiAnnualRate;

    @SerializedName("annual_rate")
    private Double annualRate;

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

}
