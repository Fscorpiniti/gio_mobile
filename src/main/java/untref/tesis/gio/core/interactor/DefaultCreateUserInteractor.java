package untref.tesis.gio.core.interactor;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.core.domain.CreateUserData;
import untref.tesis.gio.core.domain.CreateUserRequest;
import untref.tesis.gio.core.domain.User;
import untref.tesis.gio.core.domain.UserRepository;

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
