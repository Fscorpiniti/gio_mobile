package untref.tesis.gio.domain.factory;


import untref.tesis.gio.domain.repository.InvestmentRepository;
import untref.tesis.gio.infrastructure.datasource.InvestmentDataStore;
import untref.tesis.gio.infrastructure.datasource.ServerInvestmentDataStore;
import untref.tesis.gio.infrastructure.net.ApiService;
import untref.tesis.gio.infrastructure.net.InvestmentApiService;
import untref.tesis.gio.infrastructure.repository.DefaultInvestmentRepository;

public class InvestmentRepositoryFactory {

    public static InvestmentRepository build() {
        return new DefaultInvestmentRepository(buildInvestmentDataStore());
    }

    private static InvestmentDataStore buildInvestmentDataStore() {
        return new ServerInvestmentDataStore(ApiService.retrofit.create(InvestmentApiService.class));
    }
}
