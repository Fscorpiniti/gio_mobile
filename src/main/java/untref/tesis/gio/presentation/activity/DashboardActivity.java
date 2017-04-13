package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import untref.tesis.gio.R;

public class DashboardActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dashboard);
        Intent intent = getIntent();
        String email = intent.getStringExtra(LoginActivity.USER_LOGGED);
        TextView textView = (TextView) findViewById(R.id.logged_user);
        textView.setText(email);
    }

}
