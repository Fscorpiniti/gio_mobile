package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import untref.tesis.gio.R;
import untref.tesis.gio.presentation.domain.LoginPresenterFactory;
import untref.tesis.gio.presentation.presenter.LoginPresenter;
import untref.tesis.gio.domain.entity.User;

public class DefaultLoginActivity extends Activity implements LoginActivity {

    private LoginPresenter loginPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        loginPresenter = LoginPresenterFactory.build(this);
        setContentView(R.layout.default_login_activity);
    }

    @Override
    public void login(View view) {
        EditText editEmail = (EditText) findViewById(R.id.login_edit_email);
        EditText editPassword = (EditText) findViewById(R.id.login_edit_password);
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        loginPresenter.login(email, password);
    }

    public void createUser(View view) {
        Intent intent = new Intent(this, DefaultCreateUserActivity.class);
        startActivity(intent);
    }

    @Override
    public void successful(User user) {
        SharedPreferences sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("user_name", user.getName());
        editor.putFloat("user_coins", user.getCoins().floatValue());
        editor.putInt("user_id", user.getId());
        editor.commit();

        Intent intent = new Intent(this, DefaultDashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void notifyError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}