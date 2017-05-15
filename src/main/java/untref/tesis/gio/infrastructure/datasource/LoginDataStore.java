package untref.tesis.gio.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.LoginData;
import untref.tesis.gio.domain.entity.UserLogged;

public interface LoginDataStore {

    Observable<UserLogged> login(LoginData loginData);

}
