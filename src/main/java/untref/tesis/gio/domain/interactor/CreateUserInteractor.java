package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.request.CreateUserRequest;
import untref.tesis.gio.domain.entity.User;

public interface CreateUserInteractor {

    Observable<User> create(CreateUserRequest createUserRequest);

}
