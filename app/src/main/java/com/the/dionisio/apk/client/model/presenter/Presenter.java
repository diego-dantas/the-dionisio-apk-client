package com.the.dionisio.apk.client.model.presenter;

/**
 * Created by igorm on 06/05/2017.
 */

public interface Presenter
{
    PersonPresenter personAction = new PersonPresenter();
    LoginPresenter loginAction = new LoginPresenter();
    EventPresenter eventAction = new EventPresenter();
}
