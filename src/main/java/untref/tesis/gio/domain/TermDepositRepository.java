package untref.tesis.gio.domain;

import io.reactivex.Observable;

public interface TermDepositRepository {

    Observable<TermDepositInformation> findTermDepositInformationForCreation();

}