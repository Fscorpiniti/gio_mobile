package untref.tesis.gio.domain.data;


import com.google.gson.annotations.SerializedName;

public class TermDepositData {

    private transient Integer ownerId;

    @SerializedName("amount")
    private Double amount;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("rate")
    private Double rate;

    public TermDepositData(Integer ownerId, Double amount, Integer duration, Double rate) {
        this.ownerId = ownerId;
        this.amount = amount;
        this.duration = duration;
        this.rate = rate;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TermDepositData that = (TermDepositData) o;

        if (!ownerId.equals(that.ownerId)) return false;
        if (!amount.equals(that.amount)) return false;
        if (!duration.equals(that.duration)) return false;
        return rate.equals(that.rate);

    }

    @Override
    public int hashCode() {
        int result = ownerId.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + rate.hashCode();
        return result;
    }
}
