package untref.tesis.gio.presentation.presenter;

import untref.tesis.gio.presentation.activity.CreateUserActivity;
import untref.tesis.gio.domain.CreateUserRequest;
import untref.tesis.gio.domain.interactor.CreateUserInteractor;

public class DefaultCreateUserPresenter implements CreateUserPresenter {

    private CreateUserActivity createUserActivity;
    private CreateUserInteractor createUserInteractor;

    public DefaultCreateUserPresenter(CreateUserActivity createUserActivity, CreateUserInteractor createUserInteractor) {
        this.createUserActivity = createUserActivity;
        this.createUserInteractor = createUserInteractor;
    }

    @Override
    public void create(String email, String password, String name) {
        CreateUserRequest createUserRequest = new CreateUserRequest(email, password, name);
        createUserInteractor.create(createUserRequest).subscribe(user -> createUserActivity.successful(user));
    }
}
