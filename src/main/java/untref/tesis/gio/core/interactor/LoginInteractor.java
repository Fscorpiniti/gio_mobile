package untref.tesis.gio.core.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.core.domain.LoginRequest;
import untref.tesis.gio.core.domain.User;

public interface LoginInteractor {

    Observable<User> login(LoginRequest loginRequest);

}
