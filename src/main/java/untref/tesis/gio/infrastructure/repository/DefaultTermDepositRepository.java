package untref.tesis.gio.infrastructure.repository;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.data.TermDepositData;
import untref.tesis.gio.domain.entity.TermDepositInformation;
import untref.tesis.gio.domain.repository.TermDepositRepository;
import untref.tesis.gio.infrastructure.datasource.TermDepositDataStore;


public class DefaultTermDepositRepository implements TermDepositRepository {

    private TermDepositDataStore termDepositDataStore;

    public DefaultTermDepositRepository(TermDepositDataStore termDepositDataStore) {
        this.termDepositDataStore = termDepositDataStore;
    }

    @Override
    public Observable<TermDepositInformation> findTermDepositInformationForCreation() {
        return termDepositDataStore.findTermDepositInformationForCreation();
    }

    @Override
    public Observable<TermDeposit> add(TermDepositData termDepositData, String authToken) {
        return termDepositDataStore.add(termDepositData, authToken);
    }

    @Override
    public Observable<List<TermDeposit>> findByOwner(Integer ownerId, String authToken) {
        return termDepositDataStore.findByOwner(ownerId, authToken);
    }

    @Override
    public Observable<TermDeposit> force(Integer ownerId, Integer termDepositId, String authToken) {
        return termDepositDataStore.force(ownerId, termDepositId, authToken);
    }
}
