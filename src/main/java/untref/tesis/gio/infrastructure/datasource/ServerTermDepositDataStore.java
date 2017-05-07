package untref.tesis.gio.infrastructure.datasource;


import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.factory.TermDepositBuilder;
import untref.tesis.gio.domain.data.TermDepositData;
import untref.tesis.gio.domain.entity.TermDepositInformation;
import untref.tesis.gio.domain.factory.TermDepositInformationFactory;
import untref.tesis.gio.infrastructure.response.TermDepositInformationResponse;
import untref.tesis.gio.infrastructure.response.TermDepositResponse;
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

    @Override
    public Observable<TermDeposit> add(TermDepositData termDepositData) {
        return termDepositApiService.add(termDepositData.getOwnerId(), termDepositData).map(termDepositResponse ->
                buildTermDeposit(termDepositResponse));
}

    private TermDeposit buildTermDeposit(TermDepositResponse termDepositResponse) {
        return new TermDepositBuilder()
                .withAmount(termDepositResponse.getAmount())
                .withRate(termDepositResponse.getRate())
                .withStatus(termDepositResponse.getStatus())
                .build();
    }

    private TermDepositInformation buildTermDepositInformation(TermDepositInformationResponse response) {
        return TermDepositInformationFactory.build(response);
    }
}
