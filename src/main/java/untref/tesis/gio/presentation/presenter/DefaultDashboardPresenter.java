package untref.tesis.gio.presentation.presenter;

import untref.tesis.gio.domain.interactor.FindTermDepositInteractor;
import untref.tesis.gio.domain.interactor.FindUserInteractor;
import untref.tesis.gio.domain.interactor.ForceTermDepositInteractor;
import untref.tesis.gio.presentation.activity.DashboardActivity;

public class DefaultDashboardPresenter implements DashboardPresenter {

    private DashboardActivity dashboardActivity;
    private FindTermDepositInteractor findTermDepositInteractor;
    private FindUserInteractor findUserInteractor;
    private ForceTermDepositInteractor forceTermDepositInteractor;

    public DefaultDashboardPresenter(DashboardActivity dashboardActivity, FindTermDepositInteractor
            findTermDepositInteractor, FindUserInteractor findUserInteractor,
                                     ForceTermDepositInteractor forceTermDepositInteractor) {
        this.dashboardActivity = dashboardActivity;
        this.findTermDepositInteractor = findTermDepositInteractor;
        this.findUserInteractor = findUserInteractor;
        this.forceTermDepositInteractor = forceTermDepositInteractor;
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

    @Override
    public void forceTermDeposit(Integer ownerId, Integer termDepositId, String authToken) {
        forceTermDepositInteractor.force(ownerId, termDepositId, authToken).subscribe(termDeposit ->
                this.dashboardActivity.sucessfulForce(termDeposit));
    }
}
