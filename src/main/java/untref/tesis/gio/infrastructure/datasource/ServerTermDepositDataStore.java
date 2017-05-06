package untref.tesis.gio.infrastructure.datasource;


import io.reactivex.Observable;
import untref.tesis.gio.domain.TermDepositInformation;
import untref.tesis.gio.infrastructure.TermDepositInformationFactory;
import untref.tesis.gio.infrastructure.TermDepositInformationResponse;
import untref.tesis.gio.infrastructure.net.TermDepositApiService;

public class ServerTermDepositDataStore implements TermDepositDataStore {

    private TermDepositApiService termDepositApiService;

    public ServerTermDepositDataStore(TermDepositApiService termDepositApiService) {
        this.termDepositApiService = termDepositApiService;
    }

    @Override
    public Observable<TermDepositInformation> findTermDepositInformationForCreation() {
        return termDepositApiService.findTermDepositInformationForCreation().map(response ->
                buildTermDepositInformation(response));
    }

    private TermDepositInformation buildTermDepositInformation(TermDepositInformationResponse response) {
        return TermDepositInformationFactory.build(response);
    }
}
