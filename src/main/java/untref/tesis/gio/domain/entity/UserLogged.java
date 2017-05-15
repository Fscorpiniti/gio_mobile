package untref.tesis.gio.domain.entity;

public class UserLogged {

    private User user;

    private String token;

    public UserLogged(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}
