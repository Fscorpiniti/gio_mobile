package untref.tesis.gio.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import untref.tesis.gio.domain.entity.User;
import untref.tesis.gio.domain.repository.UserRepository;


public class DefaultFindUserInteractor implements FindUserInteractor {

    private UserRepository userRepository;
    private Scheduler schedulerSubscribeOn;
    private Scheduler schedulerObserveOn;

    public DefaultFindUserInteractor(UserRepository userRepository, Scheduler schedulersubscribeOn,
                                     Scheduler schedulerObserveOn) {
        this.userRepository = userRepository;
        this.schedulerObserveOn = schedulerObserveOn;
        this.schedulerSubscribeOn = schedulersubscribeOn;
    }

    @Override
    public Observable<User> findUserById(Integer ownerId, String authToken) {
        return userRepository.findById(ownerId, authToken).subscribeOn(schedulerSubscribeOn)
                .observeOn(schedulerObserveOn);
    }
}
