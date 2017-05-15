package untref.tesis.gio.presentation.presenter;

public interface CreateTermDepositPresenter {

    void findRateForDuration(Integer duration);

    void create(Integer ownerId, Double amount, Double rate, Integer duration, String authToken);
}
