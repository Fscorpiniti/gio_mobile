package untref.tesis.gio.core.domain;

public class User {

    private Integer id;

    private String email;

    public User(Integer id, String email) {
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
