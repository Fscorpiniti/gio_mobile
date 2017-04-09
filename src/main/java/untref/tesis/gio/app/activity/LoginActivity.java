package untref.tesis.gio.app.activity;


import android.view.View;

import untref.tesis.gio.core.domain.User;
import untref.tesis.gio.app.exception.ValidationException;

public interface LoginActivity {

    String USER_LOGGED = "user_logged";

    void login(View view);

    void successful(User user);

    void handleError(ValidationException e);

}