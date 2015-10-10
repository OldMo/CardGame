package com.android.cardgame.cardgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jelen on 2015-10-09.
 */
public class Guide extends Activity implements ViewPager.OnPageChangeListener {

    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;

    private ImageView[] dots;  //下方点的集合
    private  int[] ids = {R.id.lv1,R.id.lv2,R.id.lv3};

    Button start_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        initViews();
        initDots();
    }

    //加载要切换的三个view
    private void initViews(){
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.one,null));
        views.add(inflater.inflate(R.layout.two,null));
        views.add(inflater.inflate(R.layout.three,null));

        vpAdapter = new ViewPagerAdapter(views,this);
        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);

        //对“进入”按钮进行事件监听
        start_btn = (Button)views.get(2).findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Guide.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        vp.setOnPageChangeListener(this);

    }

    //点的初始化
    private void initDots(){
        dots = new ImageView[views.size()];
        for (int i = 0; i < views.size(); i++){
            dots[i] = (ImageView)findViewById(ids[i]);
        }
    }

    //滑动状态改变时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //滑动时调用
    @Override
    public void onPageSelected(int position) {
        for(int i = 0; i < ids.length; i++){
            if(position == i){
                dots[i].setImageResource(R.drawable.login_point_selected);//������ʱ��ѡ�еĵ�״̬�ı�
            }else{
                dots[i].setImageResource(R.drawable.login_point);
            }
        }
    }

    //新页面被选中时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
