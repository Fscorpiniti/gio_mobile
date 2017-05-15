package untref.tesis.gio.domain.interactor;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Mock
    private TermDepositRepository termDepositRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenFindTermDepositsWithoutTermDepositsThenReturnEmptyList() {
        List<TermDeposit> emptyList = new ArrayList<>();
        Mockito.when(termDepositRepository.findByOwner(OWNER_ID, authToken)).thenReturn(Observable.just(emptyList));

        Observable<List<TermDeposit>> termDeposits = buildFindTermDepositInteractor().findByOwner(OWNER_ID, authToken);

        TestObserver<List<TermDeposit>> testObserver = termDeposits.test();
        testObserver.assertNoErrors().assertValue(list -> list.isEmpty());
    }

    @Test
    public void whenFindTermDepositsWithTermDepositsThenReturnCompleteList() {
        TermDeposit termDeposit = Mockito.mock(TermDeposit.class);
        List<TermDeposit> emptyList = Arrays.asList(termDeposit);
        Mockito.when(termDepositRepository.findByOwner(OWNER_ID, authToken)).thenReturn(Observable.just(emptyList));

        Observable<List<TermDeposit>> termDeposits = buildFindTermDepositInteractor().findByOwner(OWNER_ID, authToken);

        TestObserver<List<TermDeposit>> testObserver = termDeposits.test();
        testObserver.assertNoErrors().assertValue(list -> list.size() == 1);
    }

    private FindTermDepositInteractor buildFindTermDepositInteractor() {
        return new DefaultFindTermDepositInteractor(termDepositRepository, getDefaultScheduler(), getDefaultScheduler());
    }

    private Scheduler getDefaultScheduler() {
        return Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS));
    }

}