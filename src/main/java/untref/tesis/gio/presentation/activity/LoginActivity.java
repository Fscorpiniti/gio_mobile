package untref.tesis.gio.presentation.activity;


import android.view.View;

import untref.tesis.gio.domain.entity.User;

public interface LoginActivity {

    String USER_LOGGED = "user_logged";

    void login(View view);

    void successful(User user);

    void notifyError(String message);

}