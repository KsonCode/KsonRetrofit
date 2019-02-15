package com.example.kson.ksonretrofit.api;

import com.example.kson.ksonretrofit.entiry.UserEntity;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * 用户模块相关接口（请求方法）
 */
public interface UserApiService {

//    @POST("small/user/v1/register")
//    @FormUrlEncoded
//    Call<UserEntity> reg( @Field("phone") String phone, @Field("pwd") String password);
    @POST
    @FormUrlEncoded
    Call<UserEntity> reg(@Url String url,@FieldMap HashMap<String,String> params);

    @GET("small/user/v1/register")
    Call<UserEntity> reg2(@Query("phone")String p, @Query("pwd")String pwd, @Body String body);

    @PUT
    @Headers({"Content-Type: application/json","Accept: application/json"})
        Call<UserEntity> updateNickname(@Header("userId") String id,@Header("sessionId") String sid,@Field("nickName") String name);


    @GET
    Call<ResponseBody> getData(@Url String url, @Path("user") String user);


}
