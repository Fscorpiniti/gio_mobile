package untref.tesis.gio.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.data.TermDepositData;
import untref.tesis.gio.domain.entity.TermDepositInformation;
import untref.tesis.gio.domain.entity.TermDeposit;

public interface TermDepositRepository {

    Observable<TermDepositInformation> findTermDepositInformationForCreation();

    Observable<TermDeposit> add(TermDepositData termDepositData, String authToken);

    Observable<List<TermDeposit>> findByOwner(Integer ownerId, String authToken);

    Observable<TermDeposit> force(Integer ownerId, Integer termDepositId, String authToken);
}
