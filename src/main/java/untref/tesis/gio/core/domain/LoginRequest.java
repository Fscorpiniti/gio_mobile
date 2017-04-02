package untref.tesis.gio.core.domain;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    private String email;

    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
