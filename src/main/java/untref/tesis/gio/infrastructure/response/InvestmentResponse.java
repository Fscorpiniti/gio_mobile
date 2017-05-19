package untref.tesis.gio.infrastructure.response;


import com.google.gson.annotations.SerializedName;

public class InvestmentResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("amount")
    private Double amount;

    @SerializedName("interest_higher")
    private Double interestHigher;

    @SerializedName("interest_lower")
    private Double interestLower;

    @SerializedName("purchasable")
    private Boolean purchasable;

    @SerializedName("text")
    private String text;

    @SerializedName("name")
    private String name;

    public InvestmentResponse(Integer id, Double amount, Double interestHigher, Double interestLower,
                              Boolean purchasable, String text, String name) {
        this.id = id;
        this.amount = amount;
        this.interestHigher = interestHigher;
        this.interestLower = interestLower;
        this.purchasable = purchasable;
        this.text = text;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getInterestHigher() {
        return interestHigher;
    }

    public Double getInterestLower() {
        return interestLower;
    }

    public Boolean getPurchasable() {
        return purchasable;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

}
