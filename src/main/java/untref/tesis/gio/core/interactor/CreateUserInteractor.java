package untref.tesis.gio.core.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.core.domain.CreateUserRequest;
import untref.tesis.gio.core.domain.User;

public interface CreateUserInteractor {

    Observable<User> create(CreateUserRequest createUserRequest);

}
