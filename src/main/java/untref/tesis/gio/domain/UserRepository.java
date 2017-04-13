package untref.tesis.gio.domain;

import io.reactivex.Observable;

public interface UserRepository {

    Observable<User> add(CreateUserData createUserData);

}

