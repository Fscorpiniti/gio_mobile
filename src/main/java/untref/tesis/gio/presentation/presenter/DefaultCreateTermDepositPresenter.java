package untref.tesis.gio.presentation.presenter;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import okhttp3.ResponseBody;
import untref.tesis.gio.domain.request.CreateTermDepositRequest;
import untref.tesis.gio.domain.interactor.CreateTermDepositInteractor;
import untref.tesis.gio.domain.interactor.FindRateInteractor;
import untref.tesis.gio.presentation.activity.CreateTermDepositActivity;
import untref.tesis.gio.presentation.domain.BodyParser;


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
                        termDepositInformation.findAmountOfMonths(duration)), exception -> handleError(exception));
    }

    @Override
    public void create(Integer ownerId, Double amount, Double rate, Integer duration) {
        createTermDepositInteractor.execute(buildCreateTermDepositRequest(ownerId, amount, rate, duration))
                .subscribe(termDeposit -> this.createTermDepositActivity.sucessfulCreationTermDeposit(termDeposit),
                           exception -> handleException(exception));
    }

    private void handleException(Throwable exception) {
        if (exception instanceof HttpException) {
            ResponseBody body = ((HttpException) exception).response().errorBody();
            this.createTermDepositActivity.notifyError(new BodyParser(body).getMessage());
        }
    }

    private CreateTermDepositRequest buildCreateTermDepositRequest(Integer ownerId, Double amount, Double rate, Integer duration) {
        return new CreateTermDepositRequest(ownerId, amount, duration, rate);
    }

    private void handleError(Throwable exception) {
        createTermDepositActivity.notifyError("El servidor no esta disponible.");
    }

}
