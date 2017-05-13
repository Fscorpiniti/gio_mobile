package untref.tesis.gio.presentation.activity;

import untref.tesis.gio.domain.entity.User;

public interface CreateUserActivity {

    void successful(User user);

    void notifyError(String message);
}
