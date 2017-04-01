package untref.tesis.gio.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import untref.tesis.gio.R;
import untref.tesis.gio.app.domain.LoginPresenterFactory;
import untref.tesis.gio.app.presenter.LoginPresenter;

public class DefaultLoginActivity extends Activity implements LoginActivity {

    private LoginPresenter loginPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        loginPresenter = LoginPresenterFactory.createPresenter(this);
        setContentView(R.layout.default_login_activity);
    }

    public void login(View view) {
        EditText editEmail = (EditText) findViewById(R.id.edit_email);
        EditText editPassword = (EditText) findViewById(R.id.edit_password);
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        loginPresenter.login(email, password);
    }

}