package untref.tesis.gio.presentation.presenter;

import untref.tesis.gio.domain.interactor.FindRateInteractor;
import untref.tesis.gio.presentation.activity.CreateTermDepositActivity;


public class DefaultCreateTermDepositPresenter implements CreateTermDepositPresenter {

    private CreateTermDepositActivity createTermDepositActivity;
    private FindRateInteractor findRateInteractor;

    public DefaultCreateTermDepositPresenter(CreateTermDepositActivity createTermDepositActivity,
                                             FindRateInteractor findRateInteractor) {
        this.createTermDepositActivity = createTermDepositActivity;
        this.findRateInteractor = findRateInteractor;
    }

    @Override
    public void findRateForDuration(Integer duration) {
        findRateInteractor.execute().subscribe(termDepositInformation -> createTermDepositActivity
                .refreshByChangeRate(termDepositInformation.findRateByDuration(duration),
                        termDepositInformation.findAmountOfMonths(duration)));
    }
}
