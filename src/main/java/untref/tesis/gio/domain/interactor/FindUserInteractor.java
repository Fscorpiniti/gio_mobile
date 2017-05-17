package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.User;

public interface FindUserInteractor {

    Observable<User> findUserById(Integer ownerId, String authToken);

}
