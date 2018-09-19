package com.ghhitech.smisseal.login.datamanager;

import com.ghhitech.smisseal.login.model.UserModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginService {

    @POST("user/login")
    Observable<UserModel> getUserLogin(@Query("phone") String userName,@Query("password") String password);

    @POST("user/login")
    Call<UserModel> login(@Query("phone") String userName, @Query("password") String password);

}
