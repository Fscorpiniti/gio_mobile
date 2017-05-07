package untref.tesis.gio.domain.factory;


import untref.tesis.gio.domain.repository.TermDepositRepository;
import untref.tesis.gio.infrastructure.repository.DefaultTermDepositRepository;
import untref.tesis.gio.infrastructure.datasource.ServerTermDepositDataStore;
import untref.tesis.gio.infrastructure.datasource.TermDepositDataStore;
import untref.tesis.gio.infrastructure.net.ApiService;
import untref.tesis.gio.infrastructure.net.TermDepositApiService;

public class TermDepositRepositoryFactory {

    public static TermDepositRepository build() {
        return new DefaultTermDepositRepository(buildTermDepositDataStore());
    }

    private static TermDepositDataStore buildTermDepositDataStore() {
        return new ServerTermDepositDataStore(ApiService.retrofit.create(TermDepositApiService.class));
    }

}
