package untref.tesis.gio.domain.interactor;


import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.LoginData;
import untref.tesis.gio.domain.LoginRepository;
import untref.tesis.gio.domain.LoginRequest;
import untref.tesis.gio.domain.User;

public class DefaultLoginInteractor implements LoginInteractor {

    private LoginRepository loginRepository;
    private Executor executor;

    public DefaultLoginInteractor(LoginRepository loginRepository, Executor executor) {
        this.loginRepository = loginRepository;
        this.executor = executor;
    }

    @Override
    public Observable<User> login(LoginRequest loginRequest) {
        return loginRepository.login(buildLoginData(loginRequest)).subscribeOn(Schedulers.from(executor))
                .observeOn(AndroidSchedulers.mainThread());
    }

    private LoginData buildLoginData(LoginRequest loginRequest) {
        return new LoginData(loginRequest.getEmail(), loginRequest.getPassword());
    }

}
