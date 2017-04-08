package untref.tesis.gio.app.presenter;

import untref.tesis.gio.app.activity.CreateUserActivity;
import untref.tesis.gio.core.domain.CreateUserRequest;
import untref.tesis.gio.core.interactor.CreateUserInteractor;

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
