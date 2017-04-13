package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.CreateUserRequest;
import untref.tesis.gio.domain.User;

public interface CreateUserInteractor {

    Observable<User> create(CreateUserRequest createUserRequest);

}
