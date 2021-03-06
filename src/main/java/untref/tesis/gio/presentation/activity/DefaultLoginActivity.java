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
import untref.tesis.gio.domain.entity.UserLogged;
import untref.tesis.gio.presentation.domain.LoginPresenterFactory;
import untref.tesis.gio.presentation.presenter.LoginPresenter;
import untref.tesis.gio.domain.entity.User;

public class DefaultLoginActivity extends Activity implements LoginActivity {

    private static final String USER_NAME = "user_name";
    private static final String AUTH_TOKEN = "auth_token";
    private static final String USER_ID = "user_id";
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
    public void successful(UserLogged userLogged) {
        SharedPreferences sharedPref = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(USER_NAME, userLogged.getUser().getName());
        editor.putString(AUTH_TOKEN, userLogged.getToken());
        editor.putInt(USER_ID, userLogged.getUser().getId());
        editor.commit();

        Intent intent = new Intent(this, DefaultDashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void notifyError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}