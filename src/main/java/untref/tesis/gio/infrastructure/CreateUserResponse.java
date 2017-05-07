package untref.tesis.gio.infrastructure;

import com.google.gson.annotations.SerializedName;

public class CreateUserResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("user_economy")
    private UserEconomyResponse userEconomyResponse;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public UserEconomyResponse getUserEconomyResponse() {
        return userEconomyResponse;
    }
}
