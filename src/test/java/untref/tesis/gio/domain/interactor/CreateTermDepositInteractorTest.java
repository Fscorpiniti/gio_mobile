package untref.tesis.gio.domain.interactor;


import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.request.CreateTermDepositRequest;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.domain.data.TermDepositData;
import untref.tesis.gio.domain.factory.TermDepositDataFactory;
import untref.tesis.gio.domain.repository.TermDepositRepository;

public class CreateTermDepositInteractorTest {

    private static final int DEFAULT_OWNER_ID = 1;
    private static final int DEFAULT_DURATION = 30;
    private static final Double DEFAULT_AMOUNT = new Double(100);
    private static final Double DEFAULT_RATE = new Double(15);
    private static final int NUMBER_THREADS = 1;

    private CreateTermDepositRequest createTermDepositRequest;

    @Test
    public void whenCreateTermDepositThenTermDepositIsCreated() {
        buildCreateTermDepositRequest(DEFAULT_OWNER_ID, DEFAULT_AMOUNT, DEFAULT_DURATION, DEFAULT_RATE);
        TermDepositData data = new TermDepositDataFactory().build(createTermDepositRequest);
        TermDeposit termDeposit = Mockito.mock(TermDeposit.class);
        TermDepositRepository termDepositRepository = Mockito.mock(TermDepositRepository.class);
        Mockito.when(termDepositRepository.add(data, authToken)).thenReturn(Observable.just(termDeposit));

        Observable<TermDeposit> termDepositObservable = new DefaultCreateTermDepositInteractor(termDepositRepository,
                getDefaultScheduler(), getDefaultScheduler()).execute(createTermDepositRequest, authToken);
        TestObserver<TermDeposit> testObserver = termDepositObservable.test();

        testObserver.assertNoErrors().assertValue(termDepositValue -> termDeposit.equals(termDepositValue));
    }

    private Scheduler getDefaultScheduler() {
        return Schedulers.from(Executors.newFixedThreadPool(NUMBER_THREADS));
    }

    private void buildCreateTermDepositRequest(Integer ownerId, Double amount, Integer duration, Double rate) {
        createTermDepositRequest = new CreateTermDepositRequest(ownerId, amount, duration, rate);
    }

}
