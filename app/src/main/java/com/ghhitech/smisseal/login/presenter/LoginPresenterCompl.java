package com.ghhitech.smisseal.login.presenter;

import android.content.Context;
import android.util.Log;

import com.ghhitech.smisseal.constants.SealConstants;
import com.ghhitech.smisseal.interceptor.CookieInterceptor;
import com.ghhitech.smisseal.interceptor.HeadersInterceptor;
import com.ghhitech.smisseal.login.datamanager.LoginService;
import com.ghhitech.smisseal.login.model.UserModel;
import com.ghhitech.smisseal.login.view.ILoginView;
import com.ghhitech.smisseal.utils.StringUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresenterCompl implements ILoginPresenter {

    private ILoginView iLoginView;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public Observable login(String userName, String password) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            return Observable.error(NullPointerException::new);
        }

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.connectTimeout(SealConstants.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new CookieInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .baseUrl(SealConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        LoginService loginService = retrofit.create(LoginService.class);

        Observable<UserModel> observable = loginService.getUserLogin(userName,password);

        return observable;
    }

    @Override
    public void clear() {
        iLoginView.clearText();
    }


}
