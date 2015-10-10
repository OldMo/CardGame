package com.android.cardgame.cardgame;

import android.graphics.Canvas;

import java.util.ArrayList;

import  java.util.List;
/**
 * Created by Jelen on 2015/4/26.
 */
public class Container {

    private List<Container> children;
    private  float x=0,y=0,width=0,height=0;
    private boolean visible = true;
    public  Container(){
        children  = new ArrayList<Container>();
    }

    public void draw(Canvas canvas){
        canvas.save();
        customChildren(canvas);
        canvas.translate(getX(),getY());
        for(Container child:children){
            if(child.isVisible()) {
                child.draw(canvas);
            }
        }

        canvas.restore();
    }

    public void customChildren(Canvas canvas){

    }

    public void addChild(Container child){
        children.add(child);
    }

    public void removeChild(Container child){
        children.remove(child);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean onTouchCard(float x,float y){
        return x > getX() && x < (getX()+getWidth()) && y > getY() && y < (getY()+getHeight());
    }
}
