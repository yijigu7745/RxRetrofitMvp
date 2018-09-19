package com.ghhitech.smisseal.situation.datemanager;

import com.ghhitech.smisseal.base.Items;
import com.ghhitech.smisseal.situation.model.SituationModel;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface SituationService {
    @POST("situation/dataDetail")
    Observable<SituationModel> getSituation();
}
