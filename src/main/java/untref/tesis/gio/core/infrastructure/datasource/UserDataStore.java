package untref.tesis.gio.core.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.core.domain.CreateUserData;
import untref.tesis.gio.core.domain.User;

public interface UserDataStore {

    Observable<User> add(CreateUserData createUserData);

}
