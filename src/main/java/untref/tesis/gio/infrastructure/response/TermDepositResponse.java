package untref.tesis.gio.infrastructure.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import untref.tesis.gio.domain.entity.TermDepositStatus;

public class TermDepositResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("amount")
    private Double amount;

    @SerializedName("rate")
    private Double rate;

    @SerializedName("expiration_date")
    private Date expiration;

    @SerializedName("status")
    private TermDepositStatus status;

    @SerializedName("owner_id")
    private Integer ownerId;

    @SerializedName("duration")
    private Integer duration;

    public TermDepositResponse() {}

    public TermDepositResponse(Integer id, Double amount, Double rate, Date expiration,
                               TermDepositStatus status, Integer ownerId, Integer duration) {
        this.id = id;
        this.amount = amount;
        this.rate = rate;
        this.expiration = expiration;
        this.status = status;
        this.ownerId = ownerId;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getRate() {
        return rate;
    }

    public Date getExpiration() {
        return expiration;
    }

    public TermDepositStatus getStatus() {
        return status;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Integer getDuration() {
        return duration;
    }
}
