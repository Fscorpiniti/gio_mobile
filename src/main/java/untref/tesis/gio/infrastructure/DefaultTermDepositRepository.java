package untref.tesis.gio.infrastructure;

import io.reactivex.Observable;
import untref.tesis.gio.domain.TermDeposit;
import untref.tesis.gio.domain.TermDepositData;
import untref.tesis.gio.domain.TermDepositInformation;
import untref.tesis.gio.domain.TermDepositRepository;
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
        return Observable.empty();
    }
}
