package untref.tesis.gio.presentation.presenter;

public interface DashboardPresenter {

    void findTermDepositsByOwner(Integer ownerId, String authToken);

    void findEconomyUserLogged(Integer ownerId, String authToken);

    void forceTermDeposit(Integer ownerId, Integer termDepositId, String authToken);

    void getAllInvestments(Integer ownerId);

    void createInvestment(Integer ownerId, Integer investmentId, String authToken);

    void findInvestmentByOwner(Integer ownerId, String authToken);
}
