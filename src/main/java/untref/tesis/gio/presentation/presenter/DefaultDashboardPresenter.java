package untref.tesis.gio.presentation.presenter;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import okhttp3.ResponseBody;
import untref.tesis.gio.domain.interactor.CreateInvestmentInteractor;
import untref.tesis.gio.domain.interactor.FindTermDepositInteractor;
import untref.tesis.gio.domain.interactor.FindUserInteractor;
import untref.tesis.gio.domain.interactor.ForceInvestmentInteractor;
import untref.tesis.gio.domain.interactor.ForceTermDepositInteractor;
import untref.tesis.gio.domain.interactor.GetInvestmentInteractor;
import untref.tesis.gio.presentation.activity.DashboardActivity;
import untref.tesis.gio.presentation.domain.BodyParser;

public class DefaultDashboardPresenter implements DashboardPresenter {

    private DashboardActivity dashboardActivity;
    private FindTermDepositInteractor findTermDepositInteractor;
    private FindUserInteractor findUserInteractor;
    private ForceTermDepositInteractor forceTermDepositInteractor;
    private GetInvestmentInteractor getInvestmentInteractor;
    private CreateInvestmentInteractor createInvestmentInteractor;
    private ForceInvestmentInteractor forceInvestmentInteractor;

    public DefaultDashboardPresenter(DashboardActivity dashboardActivity, FindTermDepositInteractor findTermDepositInteractor,
                                     FindUserInteractor findUserInteractor, ForceTermDepositInteractor forceTermDepositInteractor,
                                     GetInvestmentInteractor getInvestmentInteractor, CreateInvestmentInteractor createInvestmentInteractor,
                                     ForceInvestmentInteractor forceInvestmentInteractor) {
        this.dashboardActivity = dashboardActivity;
        this.findTermDepositInteractor = findTermDepositInteractor;
        this.findUserInteractor = findUserInteractor;
        this.forceTermDepositInteractor = forceTermDepositInteractor;
        this.getInvestmentInteractor = getInvestmentInteractor;
        this.createInvestmentInteractor = createInvestmentInteractor;
        this.forceInvestmentInteractor = forceInvestmentInteractor;
    }

    @Override
    public void findTermDepositsByOwner(Integer ownerId, String authToken) {
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
                this.dashboardActivity.sucessfulForceTermDeposit(termDeposit));
    }

    @Override
    public void getAllInvestments(Integer ownerId) {
        getInvestmentInteractor.getAllForGame(ownerId).subscribe(investments ->
            this.dashboardActivity.activeCasualInvestments(investments));
    }

    @Override
    public void createInvestment(Integer ownerId, Integer investmentId, String authToken) {
        createInvestmentInteractor.execute(ownerId, investmentId, authToken).subscribe(investments ->
                this.dashboardActivity.updateInvestments(investments),
                exception -> handleException(exception));
    }

    @Override
    public void findInvestmentByOwner(Integer ownerId, String authToken) {
        getInvestmentInteractor.findByOwnerId(ownerId, authToken).subscribe(investments ->
                this.dashboardActivity.updateInvestments(investments));
    }

    @Override
    public void forceInvestment(Integer ownerId, Integer invesmentId, String authToken) {
        forceInvestmentInteractor.execute(ownerId, invesmentId, authToken).subscribe(amount ->
                this.dashboardActivity.sucessFulForceInvestment(amount));
    }

    private void handleException(Throwable exception) {
        if (exception instanceof HttpException) {
            ResponseBody body = ((HttpException) exception).response().errorBody();
            this.dashboardActivity.notifyError(new BodyParser(body).getMessage());
        }
    }

}
