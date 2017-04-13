package untref.tesis.gio.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.domain.LoginData;
import untref.tesis.gio.domain.User;

public interface LoginDataStore {

    Observable<User> login(LoginData loginData);

}
