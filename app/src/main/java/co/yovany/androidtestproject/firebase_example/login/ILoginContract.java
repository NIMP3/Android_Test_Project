package co.yovany.androidtestproject.firebase_example.login;

import co.yovany.androidtestproject.firebase_example.login.presenter.IBasePresenter;
import co.yovany.androidtestproject.firebase_example.login.view.IBaseView;

public interface ILoginContract {

    interface ILoginView extends IBaseView<IPresenterLogin> {
        void showProgress();
        void hideProgress();

        void setEmailError(String error);
        void setPasswordError(String error);
        void showLoginError(String msg);

        void showPushNotifications();

        void showGooglePlayServicesDialog(int errorCode);
        void showGooglePlayServicesError();
        void showNetworkError();
    }

    interface IPresenterLogin extends IBasePresenter {
        void attemptLogin(String email, String password);
    }
}
