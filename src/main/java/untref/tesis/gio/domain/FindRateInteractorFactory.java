package untref.tesis.gio.domain;


import java.util.concurrent.Executors;

import untref.tesis.gio.domain.interactor.DefaultFindRateInteractor;
import untref.tesis.gio.domain.interactor.FindRateInteractor;

public class FindRateInteractorFactory {

    public static FindRateInteractor build() {
        return new DefaultFindRateInteractor(buildTermDepositRepository(), Executors.newFixedThreadPool(5));
    }

    private static TermDepositRepository buildTermDepositRepository() {
        return TermDepositRepositoryFactory.build();
    }
}
