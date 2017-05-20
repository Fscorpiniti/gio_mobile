package untref.tesis.gio.presentation.domain;

import untref.tesis.gio.domain.factory.DefaultCreateInvestmentInteractorFactory;
import untref.tesis.gio.domain.factory.DefaultGetAllInvestmentInteractorFactory;
import untref.tesis.gio.domain.factory.FindTermDepositInteractorFactory;
import untref.tesis.gio.domain.factory.ForceTermDepositInteractorFactory;
import untref.tesis.gio.domain.interactor.CreateInvestmentInteractor;
import untref.tesis.gio.domain.interactor.FindTermDepositInteractor;
import untref.tesis.gio.domain.interactor.FindUserInteractor;
import untref.tesis.gio.domain.interactor.ForceTermDepositInteractor;
import untref.tesis.gio.domain.interactor.GetInvestmentInteractor;
import untref.tesis.gio.presentation.activity.DashboardActivity;
import untref.tesis.gio.presentation.presenter.DashboardPresenter;
import untref.tesis.gio.presentation.presenter.DefaultDashboardPresenter;

public class DashboardPresenterFactory {

    public static DashboardPresenter build(DashboardActivity dashboardActivity) {
        return new DefaultDashboardPresenter(dashboardActivity, buildFindTermDepositInteractor(),
                buildFindUserInteractor(), buildForceTermDepositInteractor(), buildGetAllInvestmentInteractor(),
                buildCreateInvestmentInteractor());
    }

    private static CreateInvestmentInteractor buildCreateInvestmentInteractor() {
        return DefaultCreateInvestmentInteractorFactory.build();
    }

    private static GetInvestmentInteractor buildGetAllInvestmentInteractor() {
        return DefaultGetAllInvestmentInteractorFactory.build();
    }

    private static ForceTermDepositInteractor buildForceTermDepositInteractor() {
        return ForceTermDepositInteractorFactory.build();
    }

    private static FindUserInteractor buildFindUserInteractor() {
        return FindUserInteractorFactory.build();
    }

    private static FindTermDepositInteractor buildFindTermDepositInteractor() {
        return FindTermDepositInteractorFactory.build();
    }

}
