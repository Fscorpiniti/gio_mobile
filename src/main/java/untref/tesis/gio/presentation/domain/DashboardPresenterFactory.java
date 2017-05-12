package untref.tesis.gio.presentation.domain;

import untref.tesis.gio.domain.factory.FindTermDepositInteractorFactory;
import untref.tesis.gio.domain.interactor.FindTermDepositInteractor;
import untref.tesis.gio.presentation.activity.DashboardActivity;
import untref.tesis.gio.presentation.activity.DefaultDashboardActivity;
import untref.tesis.gio.presentation.presenter.DashboardPresenter;
import untref.tesis.gio.presentation.presenter.DefaultDashboardPresenter;

public class DashboardPresenterFactory {

    public static DashboardPresenter build(DashboardActivity dashboardActivity) {
        return new DefaultDashboardPresenter(dashboardActivity, buildFindTermDepositInteractor());
    }

    private static FindTermDepositInteractor buildFindTermDepositInteractor() {
        return FindTermDepositInteractorFactory.build();
    }

}
