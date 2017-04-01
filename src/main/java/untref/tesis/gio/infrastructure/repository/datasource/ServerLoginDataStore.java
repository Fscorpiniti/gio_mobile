package untref.tesis.gio.infrastructure.repository.datasource;

import untref.tesis.gio.infrastructure.net.LoginApiService;

public class ServerLoginDataStore implements LoginDataStore {

    private LoginApiService loginApiService;

    public ServerLoginDataStore(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    @Override
    public void login(String email, String password) {
        this.loginApiService.login(email, password);
    }

}
