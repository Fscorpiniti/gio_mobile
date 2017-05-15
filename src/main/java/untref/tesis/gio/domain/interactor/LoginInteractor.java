package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.UserLogged;
import untref.tesis.gio.domain.request.LoginRequest;

public interface LoginInteractor {

    Observable<UserLogged> login(LoginRequest loginRequest);

}
