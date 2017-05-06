package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.os.Bundle;

import untref.tesis.gio.R;

public class DefaultCreateTermDepositActivity extends Activity implements CreateTermDepositActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_term_deposit_activity);
    }

}
