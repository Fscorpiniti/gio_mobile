package untref.tesis.gio.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.domain.CreateUserData;
import untref.tesis.gio.domain.User;

public interface UserDataStore {

    Observable<User> add(CreateUserData createUserData);

}
