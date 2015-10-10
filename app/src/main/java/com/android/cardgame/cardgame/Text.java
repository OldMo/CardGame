package com.android.cardgame.cardgame;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Jelen on 2015/4/26.
 */
public class Text extends Container {

    private  Paint p;
    private  String str;
    private  int size;
    private  int color;
    public Text(String string){
        p = new Paint();
        setString(string);
    }

    public void customChildren(Canvas canvas){
        super.customChildren(canvas);
        canvas.drawText(str,50,80,p);
    }

    public String getString() {
        return str;
    }

    public void setString(String string) {
        this.str = string;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        p.setTextSize(size);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        p.setColor(color);
    }

    public android.graphics.Rect getTextBounds(){
        android.graphics.Rect r = new android.graphics.Rect();
        p.getTextBounds(getString(),0,getString().length(),r);
        return r;
    }
}
