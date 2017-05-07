package untref.tesis.gio.infrastructure.repository;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.CreateUserData;
import untref.tesis.gio.domain.entity.User;
import untref.tesis.gio.domain.repository.UserRepository;
import untref.tesis.gio.infrastructure.datasource.UserDataStore;


public class DefaultUserRepository implements UserRepository {

    private UserDataStore userDataStore;

    public DefaultUserRepository(UserDataStore userDataStore) {
        this.userDataStore = userDataStore;
    }

    @Override
    public Observable<User> add(CreateUserData createUserData) {
        return userDataStore.add(createUserData);
    }
}
