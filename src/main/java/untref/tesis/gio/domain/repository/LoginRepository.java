package untref.tesis.gio.domain.repository;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.LoginData;
import untref.tesis.gio.domain.entity.User;

public interface LoginRepository {

    Observable<User> login(LoginData loginData);

}
