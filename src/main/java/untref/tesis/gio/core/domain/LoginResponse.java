package untref.tesis.gio.core.domain;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("email")
    private String email;

    public LoginResponse() {}

    public LoginResponse(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
