package untref.tesis.gio.core.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.core.domain.LoginData;
import untref.tesis.gio.core.domain.User;

public interface LoginDataStore {

    Observable<User> login(LoginData loginData);

}
