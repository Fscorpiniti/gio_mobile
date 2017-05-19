package untref.tesis.gio.domain.entity;


public class Investment {

    private Integer id;

    private Double amount;

    private Double interestHigher;

    private Double interestLower;

    private Boolean purchasable;

    private String text;

    private String name;

    public Investment(Integer id, Double amount, Double interestHigher, Double interestLower,
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

    public boolean hasAmount() {
        return getAmount() > 0;
    }
}
