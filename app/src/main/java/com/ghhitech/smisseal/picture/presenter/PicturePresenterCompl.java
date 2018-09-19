package com.ghhitech.smisseal.picture.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.ghhitech.smisseal.constants.SealConstants;
import com.ghhitech.smisseal.login.datamanager.LoginService;
import com.ghhitech.smisseal.login.model.UserModel;
import com.ghhitech.smisseal.network.HttpProvider;
import com.ghhitech.smisseal.picture.datemanager.PictureService;
import com.ghhitech.smisseal.picture.model.PictureModel;
import com.ghhitech.smisseal.picture.view.IPictrueView;
import com.ghhitech.smisseal.utils.StringUtils;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicturePresenterCompl implements IPicturePresenter{

    private IPictrueView iPictrueView;

    public PicturePresenterCompl(IPictrueView iPictrueView){
        this.iPictrueView = iPictrueView;
    }

    @Override
    public Observable getPicture(String deviceId, String startTime, String endTime, int line,int deviceType) {

        if(StringUtils.isEmpty(deviceId)){
            iPictrueView.showMessage("请选择设备！",SealConstants.MESSAGE_TYPE_ERROR);
            return Observable.error(NullPointerException::new);
        }

        if (StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)){
            iPictrueView.showMessage("请选择开始时间与结束时间！",SealConstants.MESSAGE_TYPE_ERROR);
            return Observable.error(NullPointerException::new);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .client(HttpProvider.Builder((Context) iPictrueView))
                .baseUrl(SealConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        PictureService pictureService = retrofit.create(PictureService.class);
        Observable<PictureModel> observable = pictureService.getTaskPicture(deviceId, startTime, endTime, line,deviceType);

        LoginService loginService = retrofit.create(LoginService.class);
        Observable<UserModel> observable2 = loginService.getUserLogin("18100000001","1");

        return observable;
    }
}
