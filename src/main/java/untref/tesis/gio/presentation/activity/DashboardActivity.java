package untref.tesis.gio.presentation.activity;

import java.util.List;

import untref.tesis.gio.domain.entity.TermDeposit;

public interface DashboardActivity {

    void completeTermDepositList(List<TermDeposit> termDeposits);

    void updateUserCoins(Double coins);

    void force(TermDeposit termDeposit);

    void sucessfulForce(TermDeposit termDeposit);
}
