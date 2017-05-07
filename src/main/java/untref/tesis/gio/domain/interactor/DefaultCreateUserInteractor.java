package untref.tesis.gio.domain.interactor;

import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.data.CreateUserData;
import untref.tesis.gio.domain.request.CreateUserRequest;
import untref.tesis.gio.domain.entity.User;
import untref.tesis.gio.domain.repository.UserRepository;

public class DefaultCreateUserInteractor implements CreateUserInteractor {

    private UserRepository userRepository;
    private Executor executor;

    public DefaultCreateUserInteractor(UserRepository userRepository, Executor executor) {
        this.userRepository = userRepository;
        this.executor = executor;
    }

    @Override
    public Observable<User> create(CreateUserRequest createUserRequest) {
        return userRepository.add(buildCreateUserData(createUserRequest)).subscribeOn(Schedulers.from(executor))
                .observeOn(AndroidSchedulers.mainThread());
    }

    private CreateUserData buildCreateUserData(CreateUserRequest createUserRequest) {
        return new CreateUserData(createUserRequest.getEmail(),
                createUserRequest.getPassword(), createUserRequest.getName());
    }
}
