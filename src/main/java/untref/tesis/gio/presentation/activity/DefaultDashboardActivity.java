package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import untref.tesis.gio.R;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.presentation.adapter.ListTermDepositsAdapter;
import untref.tesis.gio.presentation.domain.DashboardPresenterFactory;
import untref.tesis.gio.presentation.presenter.DashboardPresenter;

public class DefaultDashboardActivity extends Activity implements DashboardActivity {

    private static final Integer DEFAULT_USER_ID = 0;
    private static final String DEFAULT_TOKEN = "0";
    private DashboardPresenter dashboardPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dashboard_activity);
        createListOfTermDeposits();
        dashboardPresenter = DashboardPresenterFactory.build(this);
        findTermDepositsByOwner();
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
        RecyclerView recyclerView = findRecyclerView();
        RecyclerView.Adapter adapter = new ListTermDepositsAdapter(termDeposits);
        recyclerView.setAdapter(adapter);
    }

    private boolean isAction(MenuItem item, int actionId) {
        return item.getItemId() == actionId;
    }

    private RecyclerView findRecyclerView() {
        return (RecyclerView) findViewById(R.id.list_term_deposits);
    }

    private void findTermDepositsByOwner() {
        SharedPreferences sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE);
        Integer ownerId = sharedPref.getInt("user_id", DEFAULT_USER_ID);
        String authToken = sharedPref.getString("auth_token", DEFAULT_TOKEN);

        dashboardPresenter.findByOwner(ownerId, authToken);
    }

    private void createListOfTermDeposits() {
        RecyclerView recyclerView = findRecyclerView();
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

}
