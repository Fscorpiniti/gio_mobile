package untref.tesis.gio.app.domain;

import untref.tesis.gio.app.activity.CreateUserActivity;
import untref.tesis.gio.app.presenter.CreateUserPresenter;
import untref.tesis.gio.app.presenter.DefaultCreateUserPresenter;
import untref.tesis.gio.core.domain.CreateUserInteractorFactory;
import untref.tesis.gio.core.interactor.CreateUserInteractor;

public class CreateUserPresenterFactory {

    public static CreateUserPresenter build(CreateUserActivity createUserActivity) {
        return new DefaultCreateUserPresenter(createUserActivity, buildCreateUserInteractor());
    }

    private static CreateUserInteractor buildCreateUserInteractor() {
        return CreateUserInteractorFactory.build();
    }

}
