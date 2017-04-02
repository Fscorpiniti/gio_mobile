package untref.tesis.gio.core.domain;

import io.reactivex.Observable;

public interface LoginRepository {

    Observable<User> login(LoginData loginData);

}
