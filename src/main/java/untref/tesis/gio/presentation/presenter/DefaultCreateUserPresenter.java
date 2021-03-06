package untref.tesis.gio.presentation.presenter;

import com.annimon.stream.Optional;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import okhttp3.ResponseBody;
import untref.tesis.gio.domain.validator.EmailValidator;
import untref.tesis.gio.presentation.activity.CreateUserActivity;
import untref.tesis.gio.domain.request.CreateUserRequest;
import untref.tesis.gio.domain.interactor.CreateUserInteractor;
import untref.tesis.gio.presentation.checker.EmailChecker;
import untref.tesis.gio.presentation.checker.NameChecker;
import untref.tesis.gio.presentation.checker.PasswordChecker;
import untref.tesis.gio.presentation.domain.BodyParser;
import untref.tesis.gio.presentation.domain.CreateUserRequestFactory;
import untref.tesis.gio.presentation.exception.ValidationException;

public class DefaultCreateUserPresenter implements CreateUserPresenter {

    private CreateUserActivity createUserActivity;
    private CreateUserInteractor createUserInteractor;

    public DefaultCreateUserPresenter(CreateUserActivity createUserActivity, CreateUserInteractor createUserInteractor) {
        this.createUserActivity = createUserActivity;
        this.createUserInteractor = createUserInteractor;
    }

    @Override
    public void create(String email, String password, String name) {
        Optional<CreateUserRequest> createUserRequestOptional = buildCreateUserRequest(email, password, name);

        if (createUserRequestOptional.isPresent()) {
            createUserInteractor.create(createUserRequestOptional.get())
                    .subscribe(user -> createUserActivity.successful(user),
                               exception -> handleException(exception));
        }
    }

    private void handleException(Throwable exception) {
        if (exception instanceof HttpException) {
            ResponseBody body = ((HttpException) exception).response().errorBody();
            this.createUserActivity.notifyError(new BodyParser(body).getMessage());
        }
    }

    private Optional<CreateUserRequest> buildCreateUserRequest(String email, String password, String name) {
        try {
            return Optional.of(buildCreateUserRequestFactory().build(email, password, name));
        } catch (ValidationException e) {
            createUserActivity.notifyError(e.getMessage());
            return Optional.empty();
        }
    }

    private CreateUserRequestFactory buildCreateUserRequestFactory() {
        return new CreateUserRequestFactory(buildEmailChecker(), new PasswordChecker(), new NameChecker());
    }

    private EmailChecker buildEmailChecker() {
        return new EmailChecker(new EmailValidator());
    }
}
