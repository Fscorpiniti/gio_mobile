package untref.tesis.gio.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("user_economy")
    private UserEconomyResponse userEconomyResponse;

    public LoginResponse() {}

    public LoginResponse(Integer id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

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
