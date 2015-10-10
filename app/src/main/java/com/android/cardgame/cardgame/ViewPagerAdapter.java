package com.android.cardgame.cardgame;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Jelen on 2015-10-09.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> views;
    private Context context;

    public ViewPagerAdapter(List<View> views,Context context){
        this.views = views;
        this.context = context;
    }

    //删除view方法
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }


    //加载view方法
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    //判断当前对象是不是需要的view
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
