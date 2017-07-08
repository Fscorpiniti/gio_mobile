package untref.tesis.gio.infrastructure.datasource;


import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.factory.TermDepositBuilder;
import untref.tesis.gio.domain.data.TermDepositData;
import untref.tesis.gio.domain.entity.TermDepositInformation;
import untref.tesis.gio.domain.factory.TermDepositInformationFactory;
import untref.tesis.gio.infrastructure.response.TermDepositInformationResponse;
import untref.tesis.gio.infrastructure.response.TermDepositResponse;
import untref.tesis.gio.infrastructure.net.TermDepositApiService;
import untref.tesis.gio.infrastructure.response.TermDepositResponses;

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
    public Observable<TermDeposit> add(TermDepositData termDepositData, String authToken) {
        return termDepositApiService.add(termDepositData.getOwnerId(), termDepositData, authToken).map(termDepositResponse ->
                buildTermDeposit(termDepositResponse));
}

    @Override
    public Observable<List<TermDeposit>> findByOwner(Integer ownerId, String authToken) {
        return termDepositApiService.findByOwner(ownerId, authToken).map(termDepositResponses ->
                buildTermDepositList(termDepositResponses));
    }

    @Override
    public Observable<TermDeposit> force(Integer ownerId, Integer termDepositId, String authToken) {
        return termDepositApiService.force(ownerId, termDepositId, authToken).map(termDepositResponse ->
                buildTermDeposit(termDepositResponse));
    }

    private List<TermDeposit> buildTermDepositList(TermDepositResponses termDepositResponses) {
        return Stream.of(termDepositResponses.getTermDepositResponses())
                .map(termDepositResponse -> buildTermDeposit(termDepositResponse))
                .collect(Collectors.toList());
    }

    private TermDeposit buildTermDeposit(TermDepositResponse termDepositResponse) {
        return new TermDepositBuilder()
                .withAmount(termDepositResponse.getAmount())
                .withRate(termDepositResponse.getRate())
                .withStatus(termDepositResponse.getStatus())
                .withExpiration(termDepositResponse.getExpiration())
                .withId(termDepositResponse.getId())
                .withDuration(termDepositResponse.getDuration())
                .build();
    }

    private TermDepositInformation buildTermDepositInformation(TermDepositInformationResponse response) {
        return TermDepositInformationFactory.build(response);
    }
}
