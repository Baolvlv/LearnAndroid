package com.example.bwx.oauthdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.api.AsyncBaiduRunner;
import com.baidu.api.Baidu;
import com.baidu.api.BaiduDialog;
import com.baidu.api.BaiduDialogError;
import com.baidu.api.BaiduException;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView tvAccessToken = null;
    private TextView tvResult = null;
    private Baidu mBaidu = null;
    private Gson mGson = null;
    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAccessToken = (TextView) findViewById(R.id.tv_access_token);
        tvResult  = (TextView) findViewById(R.id.tv_result);
        tvUser = (TextView) findViewById(R.id.tv_result_user);

        //第一个参数为clientId，即API Key
        mBaidu = new Baidu("PRheS6ajilCjg1muyFDGeCYz",this);

        mGson = new Gson();
    }

    public void onClickOAuth(View v){

        mBaidu.authorize(this, true, true, new BaiduDialog.BaiduDialogListener() {
            @Override
            public void onComplete(Bundle bundle) {
                //获取baidu对象中的AccessToken
                refreshUI(mBaidu.getAccessToken());
            }

            @Override
            public void onBaiduException(BaiduException e) {
                refreshUI("exception");

            }

            @Override
            public void onError(BaiduDialogError baiduDialogError) {
                refreshUI("error");

            }

            @Override
            public void onCancel() {
                refreshUI("cancel");

            }
        });

    }


    public void onClickGetInfo(View v){
        String token = mBaidu.getAccessToken();
        if(TextUtils.isEmpty(token)){
            Toast.makeText(MainActivity.this,"Token is empty",Toast.LENGTH_SHORT);
        }else{

           new Thread(){
                @Override
                public void run() {
                    String url="https://openapi.baidu.com/rest/2.0/passport/users/getInfo";
                    try {
                        //使用baidu对象request时，第二个参数会自动将包含在对象中的access Token传入
                        final String jsonText = mBaidu.request(url,null,"GET");
                        //返回对象为简单类（实体时）时，使用class型
                        final UserEntity user = mGson.fromJson(jsonText,UserEntity.class);
                        //返回对象为泛型时，使用Type方式
                        final UserEntity user = mGson.fromJson(jsonText,new TypeToken<UserEntity>(){}.getType());

                       //在主线程中实现runnable接口，完成ui的更新
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResult.setText(jsonText);
                                tvUser.setText(mGson.toJson(user));
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (BaiduException e) {
                        e.printStackTrace();
                    }
                    super.run();
                }
            }.start();



            //百度提供的异步操作类
            AsyncBaiduRunner runner = new AsyncBaiduRunner(mBaidu);
            String url="https://openapi.baidu.com/rest/2.0/passport/users/getInfo";

            runner.request(url, null, "GET", new AsyncBaiduRunner.RequestListener() {
                @Override
                public void onComplete(String json) {
                    refreshResultUI(json);

                }

                @Override
                public void onIOException(IOException e) {
                    refreshResultUI("onIOException");

                }

                @Override
                public void onBaiduException(BaiduException e) {
                    refreshResultUI("onBaiduException");

                }
            });
        }

    }


    private void refreshUI(final String msg){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvAccessToken.setText(msg);
            }
        });
    }


    private void refreshResultUI(final String msg){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText(msg);
            }
        });
    }



    class UserEntity{
        private String userid;
        private String blood;
        //对象中的命名与json中的key值不同时，使用如下序列化的方法
        @SerializedName("username")
        private String name;

        public String getUserid() {
            return userid;
        }

        public String getBlood() {
            return blood;
        }

        public String getUsername() {
            return name;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setBlood(String blood) {
            this.blood = blood;
        }

        public void setUsername(String username) {
            this.name = username;
        }
    }

}
