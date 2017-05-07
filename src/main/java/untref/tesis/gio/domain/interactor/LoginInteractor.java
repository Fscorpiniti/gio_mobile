package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.request.LoginRequest;
import untref.tesis.gio.domain.entity.User;

public interface LoginInteractor {

    Observable<User> login(LoginRequest loginRequest);

}
