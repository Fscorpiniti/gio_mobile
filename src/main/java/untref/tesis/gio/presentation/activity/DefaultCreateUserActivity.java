package untref.tesis.gio.presentation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import untref.tesis.gio.R;
import untref.tesis.gio.presentation.domain.CreateUserPresenterFactory;
import untref.tesis.gio.presentation.presenter.CreateUserPresenter;
import untref.tesis.gio.domain.entity.User;

public class DefaultCreateUserActivity extends Activity implements CreateUserActivity {

    private CreateUserPresenter createUserPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        createUserPresenter = CreateUserPresenterFactory.build(this);
        setContentView(R.layout.create_user_activity);
    }

    public void create(View view) {
        EditText editEmail = (EditText) findViewById(R.id.create_user_edit_email);
        EditText editPassword = (EditText) findViewById(R.id.create_user_edit_password);
        EditText editName = (EditText) findViewById(R.id.create_user_edit_name);
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        String name = editName.getText().toString();

        createUserPresenter.create(email, password, name);
    }

    @Override
    public void successful(User user) {
        Intent intent = new Intent(this, DefaultLoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void notifyError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
