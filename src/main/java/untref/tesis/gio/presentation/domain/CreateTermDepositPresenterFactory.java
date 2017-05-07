package untref.tesis.gio.presentation.domain;

import untref.tesis.gio.domain.factory.CreateTermDepositInteractorFactory;
import untref.tesis.gio.domain.factory.FindRateInteractorFactory;
import untref.tesis.gio.domain.interactor.CreateTermDepositInteractor;
import untref.tesis.gio.domain.interactor.FindRateInteractor;
import untref.tesis.gio.presentation.activity.CreateTermDepositActivity;
import untref.tesis.gio.presentation.presenter.CreateTermDepositPresenter;
import untref.tesis.gio.presentation.presenter.DefaultCreateTermDepositPresenter;

public class CreateTermDepositPresenterFactory {

    public static CreateTermDepositPresenter build(CreateTermDepositActivity createTermDepositActivity) {
        return new DefaultCreateTermDepositPresenter(createTermDepositActivity, buildFindRateInterator(),
                buildCreateTermDepositInteractor());
    }

    private static CreateTermDepositInteractor buildCreateTermDepositInteractor() {
        return CreateTermDepositInteractorFactory.build();
    }

    private static FindRateInteractor buildFindRateInterator() {
        return FindRateInteractorFactory.build();
    }

}
