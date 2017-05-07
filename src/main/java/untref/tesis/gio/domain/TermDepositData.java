package untref.tesis.gio.domain;


public class TermDepositData {

    private Integer ownerId;
    private Double amount;
    private Integer duration;

    public TermDepositData(Integer ownerId, Double amount, Integer duration) {
        this.ownerId = ownerId;
        this.amount = amount;
        this.duration = duration;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TermDepositData that = (TermDepositData) o;

        if (!ownerId.equals(that.ownerId)) return false;
        if (!amount.equals(that.amount)) return false;
        return duration.equals(that.duration);

    }

    @Override
    public int hashCode() {
        int result = ownerId.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + duration.hashCode();
        return result;
    }
}
