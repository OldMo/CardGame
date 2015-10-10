package com.android.cardgame.cardgame;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Jelen on 2015/4/26.
 */
public class Rect extends Container {

    private Paint p;
    private int color;
    public Rect(){
        p = new Paint();
    }

    public  Rect(float width,float height,int color){
        p = new Paint();
        setHeight(height);
        setWidth(width);
    }

    @Override
    public void customChildren(Canvas canvas){
        super.customChildren(canvas);
        canvas.drawRect(0,0,getWidth(),getHeight(),p);

    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        p.setColor(color);
    }
}
