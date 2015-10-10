package com.android.cardgame.cardgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by Jelen on 2015-10-09.
 */
public class Welcome extends Activity {

    private boolean isFirstIn;
    private static final int TIME = 2000;
    private static final int GO_HOME=1000;
    private  static final  int GO_GUIDE=1001;

    //控制跳转
    private Handler mHandler = new Handler() {
       public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case GO_HOME:
                        goHome();
                    break;
                case GO_GUIDE:
                        goGuide();
                    break;
            }
       };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        init();
    }

    //存储第一次进入记录
    private void init( ){
        SharedPreferences per = getSharedPreferences("cardgame",MODE_PRIVATE);
        isFirstIn = per.getBoolean("isFirstIn",true);
        if(!isFirstIn){
            mHandler.sendEmptyMessageDelayed(GO_HOME,TIME);
        }else{
            mHandler.sendEmptyMessageDelayed(GO_GUIDE,TIME);
            SharedPreferences.Editor editor = per.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();
        }
    }

    private void goHome(){
        Intent intent = new Intent(Welcome.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void goGuide(){
        Intent intent = new Intent(Welcome.this,Guide.class);
        startActivity(intent);
        finish();
    }

}
