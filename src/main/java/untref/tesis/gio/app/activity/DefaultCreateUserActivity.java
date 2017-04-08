package untref.tesis.gio.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import untref.tesis.gio.R;
import untref.tesis.gio.app.domain.CreateUserPresenterFactory;
import untref.tesis.gio.app.presenter.CreateUserPresenter;
import untref.tesis.gio.core.domain.User;

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

}
