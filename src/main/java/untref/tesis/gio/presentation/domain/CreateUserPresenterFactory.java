package untref.tesis.gio.presentation.domain;

import untref.tesis.gio.presentation.activity.CreateUserActivity;
import untref.tesis.gio.presentation.presenter.CreateUserPresenter;
import untref.tesis.gio.presentation.presenter.DefaultCreateUserPresenter;
import untref.tesis.gio.domain.factory.CreateUserInteractorFactory;
import untref.tesis.gio.domain.interactor.CreateUserInteractor;

public class CreateUserPresenterFactory {

    public static CreateUserPresenter build(CreateUserActivity createUserActivity) {
        return new DefaultCreateUserPresenter(createUserActivity, buildCreateUserInteractor());
    }

    private static CreateUserInteractor buildCreateUserInteractor() {
        return CreateUserInteractorFactory.build();
    }

}
