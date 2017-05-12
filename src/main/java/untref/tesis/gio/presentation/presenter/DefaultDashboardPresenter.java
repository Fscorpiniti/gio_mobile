package untref.tesis.gio.presentation.presenter;

import untref.tesis.gio.domain.interactor.FindTermDepositInteractor;
import untref.tesis.gio.presentation.activity.DashboardActivity;

public class DefaultDashboardPresenter implements DashboardPresenter {

    private DashboardActivity dashboardActivity;
    private FindTermDepositInteractor findTermDepositInteractor;

    public DefaultDashboardPresenter(DashboardActivity dashboardActivity, FindTermDepositInteractor
            findTermDepositInteractor) {
        this.dashboardActivity = dashboardActivity;
        this.findTermDepositInteractor = findTermDepositInteractor;
    }

    @Override
    public void findByOwner(Integer ownerId) {
        findTermDepositInteractor.findByOwner(ownerId).subscribe(termDeposits ->
                this.dashboardActivity.completeTermDepositList(termDeposits));
    }
}
