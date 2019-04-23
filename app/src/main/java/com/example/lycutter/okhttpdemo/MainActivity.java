package com.example.lycutter.okhttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private String url;
    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "http://www.baidu.com";
//        getDataAsync(url);
        PostDataWithParams(url);
    }

    private void getDataAsync(String url) {
        mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("请求失败");
                System.out.println(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println("response successful, body ==== : " + response.body().string());
                    System.out.println("response code = " + response.code());
                } else {
                    System.out.println("failed, the response code = " + response.code());
                }

            }
        });
    }

    private void PostDataWithParams(String url) {
        mOkHttpClient = new OkHttpClient();
        FormBody.Builder mFormBody = new FormBody.Builder(); //创建表单请求体
        mFormBody.add("user-name", "lycutter");
        mFormBody.add("password", "ly18825155386");
        Request request = new Request.Builder().url(url).post(mFormBody.build()).build(); // 传递请求体
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("请求失败");
                System.out.println(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println("response successful, body ==== : " + response.body().string());
                    System.out.println("response code = " + response.code());
                } else {
                    System.out.println("failed, the response code = " + response.code());
                }
            }
        });
    }
}
