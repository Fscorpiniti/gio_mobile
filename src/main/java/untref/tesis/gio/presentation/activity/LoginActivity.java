package untref.tesis.gio.presentation.activity;


import android.view.View;

import untref.tesis.gio.domain.entity.UserLogged;

public interface LoginActivity {

    String USER_LOGGED = "user_logged";

    void login(View view);

    void successful(UserLogged userLogged);

    void notifyError(String message);

}