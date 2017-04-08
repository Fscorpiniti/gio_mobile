package untref.tesis.gio.core.domain;

import io.reactivex.Observable;

public interface UserRepository {

    Observable<User> add(CreateUserData createUserData);

}

