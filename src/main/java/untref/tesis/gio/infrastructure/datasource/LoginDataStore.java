package untref.tesis.gio.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.LoginData;
import untref.tesis.gio.domain.entity.User;

public interface LoginDataStore {

    Observable<User> login(LoginData loginData);

}
