package untref.tesis.gio.domain;


import untref.tesis.gio.infrastructure.DefaultTermDepositRepository;
import untref.tesis.gio.infrastructure.datasource.ServerLoginDataStore;
import untref.tesis.gio.infrastructure.datasource.ServerTermDepositDataStore;
import untref.tesis.gio.infrastructure.datasource.TermDepositDataStore;
import untref.tesis.gio.infrastructure.net.ApiService;
import untref.tesis.gio.infrastructure.net.LoginApiService;
import untref.tesis.gio.infrastructure.net.TermDepositApiService;

public class TermDepositRepositoryFactory {

    public static TermDepositRepository build() {
        return new DefaultTermDepositRepository(buildTermDepositDataStore());
    }

    private static TermDepositDataStore buildTermDepositDataStore() {
        return new ServerTermDepositDataStore(ApiService.retrofit.create(TermDepositApiService.class));
    }

}
