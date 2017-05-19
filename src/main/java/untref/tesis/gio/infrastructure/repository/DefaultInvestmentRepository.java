package untref.tesis.gio.infrastructure.repository;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.Investment;
import untref.tesis.gio.domain.repository.InvestmentRepository;
import untref.tesis.gio.infrastructure.datasource.InvestmentDataStore;

public class DefaultInvestmentRepository implements InvestmentRepository {

    private InvestmentDataStore investmentDataStore;

    public DefaultInvestmentRepository(InvestmentDataStore investmentDataStore) {
        this.investmentDataStore = investmentDataStore;
    }

    @Override
    public Observable<List<Investment>> getAll() {
        return investmentDataStore.getAll();
    }

    @Override
    public Observable<List<Investment>> add(Integer ownerId, Integer investmentId, String authToken) {
        return investmentDataStore.add(ownerId, investmentId, authToken);
    }
}
