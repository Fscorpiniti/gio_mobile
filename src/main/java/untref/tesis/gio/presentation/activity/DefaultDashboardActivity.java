package untref.tesis.gio.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.function.Function;

import untref.tesis.gio.R;
import untref.tesis.gio.domain.entity.TermDeposit;
import untref.tesis.gio.presentation.domain.DashboardPresenterFactory;
import untref.tesis.gio.presentation.presenter.DashboardPresenter;

public class DefaultDashboardActivity extends AppCompatActivity implements DashboardActivity {

    private static final Integer DEFAULT_USER_ID = 0;
    private DashboardPresenter dashboardPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dashboard_activity);
        dashboardPresenter = DashboardPresenterFactory.build(this);
        findTermDepositsByOwner();
    }

    private void findTermDepositsByOwner() {
        SharedPreferences sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE);
        Integer ownerId = sharedPref.getInt("user_id", DEFAULT_USER_ID);

        dashboardPresenter.findByOwner(ownerId);
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
        ListView listView = (ListView) findViewById(R.id.list_term_deposits);
        String[] values = buildList(termDeposits);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
    }

    private String[] buildList(List<TermDeposit> termDeposits) {
       return termDeposits.stream().map(buildMessageList()).toArray(String[]::new);
    }

    private Function<TermDeposit, String> buildMessageList() {
        return termDeposit -> new StringBuilder("Plazo fijo activo por ").append(termDeposit.getAmount())
                .append(" con vencimiento en ").append(termDeposit.getExpiration()).toString();
    }

    private boolean isAction(MenuItem item, int actionId) {
        return item.getItemId() == actionId;
    }

}
