package untref.tesis.gio.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import untref.tesis.gio.R;
import untref.tesis.gio.core.domain.LoginFactory;
import untref.tesis.gio.app.presenter.LoginPresenter;

public class DefaultLoginActivity extends Activity implements LoginActivity {

    private LoginPresenter loginPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        loginPresenter = LoginFactory.createPresenter(this);
        setContentView(R.layout.default_login_activity);
    }

    public void login(View view) {
        EditText editEmail = (EditText) view.findViewById(R.id.edit_email);
        EditText editPassword = (EditText) view.findViewById(R.id.edit_password);
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        loginPresenter.login(email, password);
    }

}