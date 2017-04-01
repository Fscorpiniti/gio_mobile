package untref.tesis.gio.core.interactor;

import untref.tesis.gio.core.domain.LoginRepository;

public class DefaultLoginInteractor implements LoginInteractor {

    private LoginRepository loginRepository;

    public DefaultLoginInteractor(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void login(String email, String password) {
        loginRepository.login(email, password);
    }

}
