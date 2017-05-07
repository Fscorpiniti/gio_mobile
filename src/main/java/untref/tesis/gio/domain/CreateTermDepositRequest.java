package untref.tesis.gio.domain;


public class CreateTermDepositRequest {

    private Integer ownerId;
    private Double amount;
    private Integer duration;
    private Double rate;

    public CreateTermDepositRequest(Integer ownerId, Double amount, Integer duration, Double rate) {
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
}
