package untref.tesis.gio.domain.repository;


import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.Investment;

public interface InvestmentRepository {

    Observable<List<Investment>> getAll(Integer ownerId);

    Observable<List<Investment>> add(Integer ownerId, Integer investmentId, String authToken);

    Observable<List<Investment>> findByOwnerId(Integer ownerId, String authToken);
}
