package untref.tesis.gio.core.domain;

import org.apache.commons.lang3.StringUtils;

public class LoginRequest {

    private String email;

    private String password;

    public LoginRequest(String email, String password) {
        checkIsNotBlank(email, "Email is required");
        checkIsNotBlank(password, "Password is required");

        this.email = email;
        this.password = password;
    }

    private void checkIsNotBlank(String value, String message) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
