package untref.tesis.gio.presentation.activity;


import android.view.View;

import untref.tesis.gio.domain.User;
import untref.tesis.gio.presentation.exception.ValidationException;

public interface LoginActivity {

    String USER_LOGGED = "user_logged";

    void login(View view);

    void successful(User user);

    void notifyError(String message);

}