package untref.tesis.gio.presentation.presenter;

import untref.tesis.gio.domain.request.CreateTermDepositRequest;
import untref.tesis.gio.domain.interactor.CreateTermDepositInteractor;
import untref.tesis.gio.domain.interactor.FindRateInteractor;
import untref.tesis.gio.presentation.activity.CreateTermDepositActivity;


public class DefaultCreateTermDepositPresenter implements CreateTermDepositPresenter {

    private CreateTermDepositActivity createTermDepositActivity;
    private FindRateInteractor findRateInteractor;
    private CreateTermDepositInteractor createTermDepositInteractor;

    public DefaultCreateTermDepositPresenter(CreateTermDepositActivity createTermDepositActivity,
                                             FindRateInteractor findRateInteractor,
                                             CreateTermDepositInteractor createTermDepositInteractor) {
        this.createTermDepositActivity = createTermDepositActivity;
        this.findRateInteractor = findRateInteractor;
        this.createTermDepositInteractor = createTermDepositInteractor;
    }

    @Override
    public void findRateForDuration(Integer duration) {
        findRateInteractor.execute().subscribe(termDepositInformation -> createTermDepositActivity
                .refreshByChangeRate(termDepositInformation.findRateByDuration(duration),
                        termDepositInformation.findAmountOfMonths(duration)));
    }

    @Override
    public void create(Integer ownerId, Double amount, Double rate, Integer duration) {
        createTermDepositInteractor.execute(buildCreateTermDepositRequest(ownerId, amount, rate, duration))
                .subscribe(termDeposit -> this.createTermDepositActivity.sucessfulCreationTermDeposit(termDeposit));
    }

    private CreateTermDepositRequest buildCreateTermDepositRequest(Integer ownerId, Double amount, Double rate, Integer duration) {
        return new CreateTermDepositRequest(ownerId, amount, duration, rate);
    }

}
