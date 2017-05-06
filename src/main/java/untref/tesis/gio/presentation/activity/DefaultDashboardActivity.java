package untref.tesis.gio.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import untref.tesis.gio.R;

public class DefaultDashboardActivity extends AppCompatActivity implements DashboardActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dashboard_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (isCreateTermDepositAction(item)) {
            Intent intent = new Intent(this, DefaultCreateTermDepositActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isCreateTermDepositAction(MenuItem item) {
        return item.getItemId() == R.id.create_term_deposit;
    }

}
