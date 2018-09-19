package com.ghhitech.smisseal.picture.datemanager;

import com.ghhitech.smisseal.picture.model.PictureModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PictureService {
    @POST("task/photoList.do")
    Observable<PictureModel> getTaskPicture(@Query("deviceId") String deviceId, @Query("startTime") String startTime, @Query("endTime") String endTime, @Query("line") int line, @Query("deviceType") int deviceType);

    @POST("task/photoList.do")
    Call<PictureModel> getPicture(@Query("deviceId") String deviceId, @Query("startTime") String startTime, @Query("endTime") String endTime, @Query("line") int line, @Query("deviceType") int deviceType);

}
