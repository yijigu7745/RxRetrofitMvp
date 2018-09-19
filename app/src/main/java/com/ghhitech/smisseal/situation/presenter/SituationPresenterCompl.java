package com.ghhitech.smisseal.situation.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.ghhitech.smisseal.base.Items;
import com.ghhitech.smisseal.constants.SealConstants;
import com.ghhitech.smisseal.datamanager.DataManager;
import com.ghhitech.smisseal.interceptor.CookieInterceptor;
import com.ghhitech.smisseal.interceptor.HeadersInterceptor;
import com.ghhitech.smisseal.network.HttpProvider;
import com.ghhitech.smisseal.situation.datemanager.SituationService;
import com.ghhitech.smisseal.situation.model.SituationModel;
import com.ghhitech.smisseal.situation.view.ISituationView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SituationPresenterCompl implements ISituationPresenter{

    private ISituationView iSituationView;

    public SituationPresenterCompl(ISituationView iSituationView){
        this.iSituationView = iSituationView;
    }

    @Override
    public Observable getSituationInfo() {

        Retrofit retrofit = new Retrofit.Builder()
                .client(HttpProvider.Builder((Context) iSituationView))
                .baseUrl(SealConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        SituationService situationService = retrofit.create(SituationService.class);

        Observable<SituationModel> observable = situationService.getSituation();

        return observable;
    }
}
