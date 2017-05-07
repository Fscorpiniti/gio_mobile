package untref.tesis.gio.domain.interactor;


import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import untref.tesis.gio.domain.CreateTermDepositRequest;
import untref.tesis.gio.domain.TermDeposit;
import untref.tesis.gio.domain.TermDepositData;
import untref.tesis.gio.domain.TermDepositDataFactory;
import untref.tesis.gio.domain.TermDepositRepository;

public class CreateTermDepositInteractorTest {

    private static final int DEFAULT_OWNER_ID = 1;
    private static final int DEFAULT_DURATION = 30;
    private static final int DEFAULT_AMOUNT = 100;

    @Test
    public void whenCreateTermDepositThenTermDepositIsCreated() {
        Integer ownerId = DEFAULT_OWNER_ID;
        Double amount = new Double(DEFAULT_AMOUNT);
        Integer duration = DEFAULT_DURATION;
        CreateTermDepositRequest request = new CreateTermDepositRequest(ownerId, amount, duration);
        TermDepositData data = new TermDepositDataFactory().build(request);
        TermDeposit termDeposit = Mockito.mock(TermDeposit.class);

        TermDepositRepository termDepositRepository = Mockito.mock(TermDepositRepository.class);
        Mockito.when(termDepositRepository.add(data)).thenReturn(Observable.just(termDeposit));
        CreateTermDepositInteractor createTermDepositInteractor = new
                DefaultCreateTermDepositInteractor(termDepositRepository, Schedulers.from(Executors.newFixedThreadPool(1)),
                Schedulers.from(Executors.newFixedThreadPool(1)));
        Observable<TermDeposit> result = createTermDepositInteractor.execute(request);
        TestObserver<TermDeposit> testObserver = result.test();

        testObserver.assertNoErrors().assertValue(termDepositValue -> termDeposit.equals(termDepositValue));
    }

}
