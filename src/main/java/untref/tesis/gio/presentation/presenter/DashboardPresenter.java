package untref.tesis.gio.presentation.presenter;

public interface DashboardPresenter {

    void findByOwner(Integer ownerId, String authToken);

    void findEconomyUserLogged(Integer ownerId, String authToken);

    void forceTermDeposit(Integer ownerId, Integer termDepositId, String authToken);

    void getAllInvestments();
}
