package com.ghhitech.smisseal.picture.presenter;

import android.widget.ImageView;

import io.reactivex.Observable;

public interface IPicturePresenter {
    Observable getPicture(String deviceId, String startTime,String endTime,int line,int deviceType);
}
