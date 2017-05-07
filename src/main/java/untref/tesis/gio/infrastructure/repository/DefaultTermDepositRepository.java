package untref.tesis.gio.infrastructure.repository;

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
    public Observable<TermDeposit> add(TermDepositData termDepositData) {
        return termDepositDataStore.add(termDepositData);
    }
}