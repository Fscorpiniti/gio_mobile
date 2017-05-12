package untref.tesis.gio.domain.interactor;


import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.repository.TermDepositRepository;

public class FindTermDepositInteractorTest {

    private static final int NUMBER_THREADS = 1;
    private static final int OWNER_ID = 1;

    @Test
    public void whenFindTermDepositsWithoutTermDepositsThenReturnEmptyList() {
        TermDepositRepository termDepositRepository = Mockito.mock(TermDepositRepository.class);
        Mockito.when(termDepositRepository.findByOwner(OWNER_ID)).thenReturn(Observable
                .just(new ArrayList<>()));
        FindTermDepositInteractor findTermDepositInteractor = new
            DefaultFindTermDepositInteractor(termDepositRepository, getDefaultScheduler(), getDefaultScheduler());

        Observable<List<TermDeposit>> termDeposits = findTermDepositInteractor.findByOwner(OWNER_ID);
        TestObserver<List<TermDeposit>> testObserver = termDeposits.test();

        testObserver.assertNoErrors().assertValue(list -> list.isEmpty());
    }

    private Scheduler getDefaultScheduler() {
        return Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS));
    }

}