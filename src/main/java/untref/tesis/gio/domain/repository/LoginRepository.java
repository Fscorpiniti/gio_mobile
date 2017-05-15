package untref.tesis.gio.domain.repository;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.LoginData;
import untref.tesis.gio.domain.entity.User;
import untref.tesis.gio.domain.entity.UserLogged;

public interface LoginRepository {

    Observable<UserLogged> login(LoginData loginData);

}
