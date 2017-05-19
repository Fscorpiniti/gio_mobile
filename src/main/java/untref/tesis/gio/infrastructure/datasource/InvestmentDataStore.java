package untref.tesis.gio.infrastructure.datasource;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.Investment;

public interface InvestmentDataStore {

    Observable<List<Investment>> getAll();

}
