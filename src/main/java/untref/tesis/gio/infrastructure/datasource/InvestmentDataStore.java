package untref.tesis.gio.infrastructure.datasource;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.Investment;

public interface InvestmentDataStore {

    Observable<List<Investment>> getAll(Integer ownerId);

    Observable<List<Investment>> add(Integer ownerId, Integer investmentId, String authToken);

    Observable<List<Investment>> findByOwnerId(Integer ownerId, String authToken);

    Observable<Double> force(Integer ownerId, Integer invesmentId, String authToken);
}
