package untref.tesis.gio.infrastructure;


import com.google.gson.annotations.SerializedName;

public class UserEconomyResponse {

    @SerializedName("coins")
    private Double coins;

    public UserEconomyResponse() {}

    public UserEconomyResponse(Double coins) {
        this.coins = coins;
    }

    public Double getCoins() {
        return coins;
    }

}
