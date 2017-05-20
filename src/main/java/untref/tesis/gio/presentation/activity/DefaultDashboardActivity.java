package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;

import untref.tesis.gio.R;
import untref.tesis.gio.domain.entity.Investment;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.presentation.adapter.ListInvestmentAdapter;
import untref.tesis.gio.presentation.adapter.ListTermDepositsAdapter;
import untref.tesis.gio.presentation.domain.DashboardPresenterFactory;
import untref.tesis.gio.presentation.presenter.DashboardPresenter;

public class DefaultDashboardActivity extends Activity implements DashboardActivity {

    private static final Integer DEFAULT_USER_ID = 0;
    private static final String DEFAULT_TOKEN = "0";
    private static final String CANTIDAD_DE_MONEDAS_PARA_INVERTIR = "Cantidad de monedas para invertir: ";
    private static final String USER = "user";
    private static final String USER_ID = "user_id";
    private static final String AUTH_TOKEN = "auth_token";
    private static final int FIRST_THRESHOLD = 60000;
    private static final int REPEAT_VALUE = 60000;
    private static final int RANDOM_NUMBER_ORIGIN = 0;
    private DashboardPresenter dashboardPresenter;
    private TimerTask timerTask;
    private List<Investment> investments;
    private Handler handler = new Handler();
    private Investment selected;
    private Timer timer;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dashboard_activity);
        createRecyclerView(R.id.list_term_deposits);
        createRecyclerView(R.id.list_investments);
        dashboardPresenter = DashboardPresenterFactory.build(this);
        findUserEconomy();
        findTermDepositsByOwner();
        findInvestmentsByOwner();
        getAllInvestments();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (isAction(item, R.id.create_term_deposit)) {
            Intent intent = new Intent(this, DefaultCreateTermDepositActivity.class);
            startActivity(intent);
            return true;
        }

        if (isAction(item, R.id.logout)) {
            Intent intent = new Intent(this, DefaultLoginActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void completeTermDepositList(List<TermDeposit> termDeposits) {
        RecyclerView recyclerView = findRecyclerView(R.id.list_term_deposits);
        RecyclerView.Adapter adapter = new ListTermDepositsAdapter(termDeposits, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateUserCoins(Double coins) {
        TextView coinsTextView = (TextView) findViewById(R.id.coins_text_input);
        coinsTextView.setText(CANTIDAD_DE_MONEDAS_PARA_INVERTIR + coins);
    }

    @Override
    public void force(TermDeposit termDeposit) {
        SharedPreferences sharedPref = getSharedPreferences(USER, Context.MODE_PRIVATE);
        Integer ownerId = getUserId(sharedPref);
        String authToken = getAuthToken(sharedPref);
        Integer termDepositId = termDeposit.getId();
        dashboardPresenter.forceTermDeposit(ownerId, termDepositId, authToken);
    }

    @Override
    public void sucessfulForceTermDeposit(TermDeposit termDeposit) {
        findTermDepositsByOwner();
        findUserEconomy();
        Toast.makeText(this, "Acreditacion exitosa por :" + termDeposit.calculateValueToBelieve(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void activeCasualInvestments(List<Investment> investments) {
        this.investments = investments;
        startTimer();
    }

    @Override
    public void updateInvestments(List<Investment> refreshInvestments) {
        findUserEconomy();
        getAllInvestments();
        RecyclerView recyclerView = findRecyclerView(R.id.list_investments);
        RecyclerView.Adapter adapter = new ListInvestmentAdapter(refreshInvestments, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void force(Investment investment) {
        SharedPreferences sharedPref = getSharedPreferences(USER, Context.MODE_PRIVATE);
        Integer ownerId = getUserId(sharedPref);
        String authToken = getAuthToken(sharedPref);
        Integer invesmentId = investment.getId();
        dashboardPresenter.forceInvestment(ownerId, invesmentId, authToken);
    }

    @Override
    public void sucessFulForceInvestment(Double amount) {
        findUserEconomy();
        findInvestmentsByOwner();
        Toast.makeText(this, "Acreditacion exitosa por :" + amount, Toast.LENGTH_SHORT).show();
    }

    private void startTimer() {
        if (timer == null) {
            timer = new Timer();
            initializeTimerTask();
            timer.schedule(timerTask, FIRST_THRESHOLD, REPEAT_VALUE);
        }
    }

    private void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!investments.isEmpty()) {
                            showLocationDialog();
                        }
                    }
                });
            }
        };
    }

    private void showLocationDialog() {
        IntStream random = new Random().ints(RANDOM_NUMBER_ORIGIN, investments.size());
        selected = investments.get(random.findFirst().getAsInt());
        SharedPreferences sharedPref = getSharedPreferences(USER, Context.MODE_PRIVATE);
        Integer ownerId = getUserId(sharedPref);
        String authToken = getAuthToken(sharedPref);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyDialogTheme);
        builder.setMessage(buildMessageToDialog(selected));

        if (selected.getPurchasable()) {
            builder.setTitle(getString(R.string.investment_dialog_title));
            builder.setPositiveButton(R.string.investment_ok,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dashboardPresenter.createInvestment(ownerId, selected.getId(),
                                    authToken);
                        }
                    });
        } else {
            builder.setTitle(getString(R.string.concept_dialog_default_title));
        }

        builder.setNegativeButton(R.string.investment_cancel,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String buildMessageToDialog(Investment selected) {
        StringBuilder builder = new StringBuilder(selected.getText());
        if (selected.getPurchasable()) {
            builder.append(" - Monto de inversion : ").append(selected.getAmount());
        }
        return builder.toString();
    }

    private boolean isAction(MenuItem item, int actionId) {
        return item.getItemId() == actionId;
    }

    private RecyclerView findRecyclerView(Integer id) {
        return (RecyclerView) findViewById(id);
    }

    private void findInvestmentsByOwner() {
        SharedPreferences sharedPref = getSharedPreferences(USER, Context.MODE_PRIVATE);
        Integer ownerId = getUserId(sharedPref);
        String authToken = getAuthToken(sharedPref);

        dashboardPresenter.findInvestmentByOwner(ownerId, authToken);
    }

    private void findTermDepositsByOwner() {
        SharedPreferences sharedPref = getSharedPreferences(USER, Context.MODE_PRIVATE);
        Integer ownerId = getUserId(sharedPref);
        String authToken = getAuthToken(sharedPref);

        dashboardPresenter.findTermDepositsByOwner(ownerId, authToken);
    }

    private String getAuthToken(SharedPreferences sharedPref) {
        return sharedPref.getString(AUTH_TOKEN, DEFAULT_TOKEN);
    }

    private void createRecyclerView(Integer id) {
        RecyclerView recyclerView = findRecyclerView(id);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void findUserEconomy() {
        SharedPreferences sharedPref = getSharedPreferences(USER, Context.MODE_PRIVATE);
        Integer ownerId = getUserId(sharedPref);
        String authToken = getAuthToken(sharedPref);
        dashboardPresenter.findEconomyUserLogged(ownerId, authToken);
    }

    private int getUserId(SharedPreferences sharedPref) {
        return sharedPref.getInt(USER_ID, DEFAULT_USER_ID);
    }

    private void getAllInvestments() {
        SharedPreferences sharedPref = getSharedPreferences(USER, Context.MODE_PRIVATE);
        this.dashboardPresenter.getAllInvestments(getUserId(sharedPref));
    }

}
