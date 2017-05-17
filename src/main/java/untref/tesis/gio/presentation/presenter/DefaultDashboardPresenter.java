package untref.tesis.gio.presentation.presenter;

import untref.tesis.gio.domain.interactor.FindTermDepositInteractor;
import untref.tesis.gio.domain.interactor.FindUserInteractor;
import untref.tesis.gio.presentation.activity.DashboardActivity;

public class DefaultDashboardPresenter implements DashboardPresenter {

    private DashboardActivity dashboardActivity;
    private FindTermDepositInteractor findTermDepositInteractor;
    private FindUserInteractor findUserInteractor;

    public DefaultDashboardPresenter(DashboardActivity dashboardActivity, FindTermDepositInteractor
            findTermDepositInteractor, FindUserInteractor findUserInteractor) {
        this.dashboardActivity = dashboardActivity;
        this.findTermDepositInteractor = findTermDepositInteractor;
        this.findUserInteractor = findUserInteractor;
    }

    @Override
    public void findByOwner(Integer ownerId, String authToken) {
        findTermDepositInteractor.findByOwner(ownerId, authToken).subscribe(termDeposits ->
                this.dashboardActivity.completeTermDepositList(termDeposits));
    }

    @Override
    public void findEconomyUserLogged(Integer ownerId, String authToken) {
        findUserInteractor.findUserById(ownerId, authToken).subscribe(user ->
            this.dashboardActivity.updateUserCoins(user.getCoins()));
    }
}
