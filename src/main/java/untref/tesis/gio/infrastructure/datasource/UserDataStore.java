package untref.tesis.gio.infrastructure.datasource;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.CreateUserData;
import untref.tesis.gio.domain.entity.User;

public interface UserDataStore {

    Observable<User> add(CreateUserData createUserData);

    Observable<User> findById(Integer ownerId, String authToken);
}
