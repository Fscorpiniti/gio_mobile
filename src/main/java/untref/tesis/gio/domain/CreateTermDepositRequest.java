package untref.tesis.gio.domain;


public class CreateTermDepositRequest {

    private Integer ownerId;
    private Double amount;
    private Integer duration;

    public CreateTermDepositRequest(Integer ownerId, Double amount, Integer duration) {
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
}
