package untref.tesis.gio.core.domain;

import com.google.gson.annotations.SerializedName;

public class CreateUserResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
