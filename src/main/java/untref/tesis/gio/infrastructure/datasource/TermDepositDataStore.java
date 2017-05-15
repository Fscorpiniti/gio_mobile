package untref.tesis.gio.infrastructure.datasource;


import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.data.TermDepositData;
import untref.tesis.gio.domain.entity.TermDepositInformation;

public interface TermDepositDataStore {

    Observable<TermDepositInformation> findTermDepositInformationForCreation();

    Observable<TermDeposit> add(TermDepositData termDepositData, String authToken);

    Observable<List<TermDeposit>> findByOwner(Integer ownerId, String authToken);
}
