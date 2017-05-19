package untref.tesis.gio.infrastructure.datasource;

import java.util.List;
import java.util.stream.Collectors;

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
    public Observable<List<Investment>> getAll() {
        return investmentApiService.getAll().map(investmentsResponse -> buildInvestmentList(investmentsResponse));
    }

    private List<Investment>  buildInvestmentList(InvestmentsResponse investmentsResponse) {
        return investmentsResponse.getInvestments().stream().map(investmentResponse -> buildInvestment(investmentResponse))
                .collect(Collectors.toList());
    }

    private Investment buildInvestment(InvestmentResponse investmentResponse) {
        return new Investment(investmentResponse.getId(), investmentResponse.getAmount(), investmentResponse.getInterestHigher(),
                investmentResponse.getInterestLower(), investmentResponse.getPurchasable(), investmentResponse.getText(),
                investmentResponse.getName());
    }

}