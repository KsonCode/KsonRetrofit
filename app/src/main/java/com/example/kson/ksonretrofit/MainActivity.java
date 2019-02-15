package com.example.kson.ksonretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kson.ksonretrofit.api.Api;
import com.example.kson.ksonretrofit.api.UserApiService;
import com.example.kson.ksonretrofit.entiry.UserEntity;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    /**
     * 注册
     * @param view
     */
    public void reg(View view) {

        //模式：外观模式

        //设计模式：构建者模式


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        //第一步
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)//主机名
                .addConverterFactory(GsonConverterFactory.create())//gson解析器
                .client(okHttpClient)//关联ok
                .build();

        //第二步 ,创建请求接口类对象，体现一个动态代理模式
        UserApiService userApiService = retrofit.create(UserApiService.class);

        HashMap<String,String> params = new HashMap<>();
        params.put("phone","186129910000");
        params.put("pwd","186129910000");
        //第三步，创建请求对象
        final Call<UserEntity> reg = userApiService.reg(Api.REG_URL,params);

        userApiService.reg2("","","xxdffdfdfdfdfdfdfdfdfdfdfdfdfdfdfdf");


        //第四部，请求
        reg.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                System.out.println(Thread.currentThread().getName());
                UserEntity userEntity = response.body();
                Toast.makeText(MainActivity.this,userEntity.message,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {

            }
        });

//        userApiService.reg().enqueue(new Callback<UserEntity>() {
//            @Override
//            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<UserEntity> call, Throwable t) {
//
//            }
//        });

        userApiService.updateNickname("","","");
        userApiService.getData(Api.PATH_URL,"1").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}
