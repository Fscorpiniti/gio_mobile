package untref.tesis.gio.infrastructure.datasource;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import io.reactivex.Observable;
import untref.tesis.gio.domain.entity.Investment;
import untref.tesis.gio.infrastructure.net.InvestmentApiService;
import untref.tesis.gio.infrastructure.response.InvestmentResponse;
import untref.tesis.gio.infrastructure.response.InvestmentsResponse;


public class ServerInvestmentDataStore implements InvestmentDataStore {

    private InvestmentApiService investmentApiService;

    public ServerInvestmentDataStore(InvestmentApiService investmentApiService) {
        this.investmentApiService = investmentApiService;
    }

    @Override
    public Observable<List<Investment>> getAll(Integer ownerId) {
        return investmentApiService.getAll(ownerId).map(investmentsResponse -> buildInvestmentList(investmentsResponse));
    }

    @Override
    public Observable<List<Investment>> add(Integer ownerId, Integer investmentId, String authToken) {
        return investmentApiService.add(ownerId, investmentId, authToken)
                .map(investmentsResponse -> buildInvestmentList(investmentsResponse));
    }

    @Override
    public Observable<List<Investment>> findByOwnerId(Integer ownerId, String authToken) {
        return investmentApiService.findByOwnerId(ownerId, authToken)
                .map(investmentsResponse -> buildInvestmentList(investmentsResponse));
    }

    @Override
    public Observable<Double> force(Integer ownerId, Integer invesmentId, String authToken) {
        return investmentApiService.force(ownerId, invesmentId, authToken);
    }

    private List<Investment>  buildInvestmentList(InvestmentsResponse investmentsResponse) {
        return Stream.of(investmentsResponse.getInvestments()).map(investmentResponse -> buildInvestment(investmentResponse))
                .collect(Collectors.toList());
    }

    private Investment buildInvestment(InvestmentResponse investmentResponse) {
        return new Investment(investmentResponse.getId(), investmentResponse.getAmount(), investmentResponse.getInterestHigher(),
                investmentResponse.getInterestLower(), investmentResponse.getPurchasable(), investmentResponse.getText(),
                investmentResponse.getName());
    }

}
