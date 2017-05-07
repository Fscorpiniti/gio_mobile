package untref.tesis.gio.domain.entity;

public class User {

    private Integer id;
    private String email;
    private String name;
    private UserEconomy userEconomy;

    public User(Integer id, String email, String name, UserEconomy userEconomy) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.userEconomy = userEconomy;
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

    public UserEconomy getUserEconomy() {
        return userEconomy;
    }

    public Double getCoins() {
        return userEconomy.getCoins();
    }
}
