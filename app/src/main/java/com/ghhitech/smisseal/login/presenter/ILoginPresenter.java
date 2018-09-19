package com.ghhitech.smisseal.login.presenter;

import io.reactivex.Observable;

public interface ILoginPresenter {

    Observable login(String userName,String password);

    void clear();
}
