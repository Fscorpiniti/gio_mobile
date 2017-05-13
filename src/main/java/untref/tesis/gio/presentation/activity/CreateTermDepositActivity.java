package untref.tesis.gio.presentation.activity;

import untref.tesis.gio.domain.entity.TermDeposit;

public interface CreateTermDepositActivity {

    void refreshByChangeRate(Double rate, Integer duration);

    void sucessfulCreationTermDeposit(TermDeposit termDeposit);

    void notifyError(String message);
}
