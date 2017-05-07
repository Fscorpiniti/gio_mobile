package untref.tesis.gio.infrastructure.datasource;


import io.reactivex.Observable;
import untref.tesis.gio.domain.TermDeposit;
import untref.tesis.gio.domain.TermDepositData;
import untref.tesis.gio.domain.TermDepositInformation;

public interface TermDepositDataStore {

    Observable<TermDepositInformation> findTermDepositInformationForCreation();

    Observable<TermDeposit> add(TermDepositData termDepositData);

}
