package untref.tesis.gio.domain.repository;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.CreateUserData;
import untref.tesis.gio.domain.entity.User;

public interface UserRepository {

    Observable<User> add(CreateUserData createUserData);

}

