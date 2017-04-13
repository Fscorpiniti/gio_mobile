package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.LoginRequest;
import untref.tesis.gio.domain.User;

public interface LoginInteractor {

    Observable<User> login(LoginRequest loginRequest);

}
