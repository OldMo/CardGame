package com.android.cardgame.cardgame;

import android.graphics.Color;

/**
 * Created by Jelen on 2015/4/26.
 */
public class Card extends Container {

    private Rect bg;
    private Text label;
     private int num = 1;
    public Card(int num,float width, float height){
        this.num = num;
        setWidth(width);
        setHeight(height);

        System.out.println(width+"-"+height);
        bg = new Rect(width,height,Color.GREEN);
/* bg = new Rect(width,height, Color.BLUE); */
        addChild(bg);

        label = new Text(num+"");
        label.setColor(Color.RED);
        label.setSize(50);

        android.graphics.Rect bounds = label.getTextBounds();
        label.setX((getWidth()-bounds.width()) / 2 );
        label.setY((getHeight()+bounds.height()) / 2 );

//        System.out.println(((getWidth()-bounds.width()) / 2)+"-"+((getHeight()+bounds.height()) / 2));

        addChild(label);
        showAll();
    }

    public void showAll(){
        label.setVisible(true);
        bg.setColor(Color.rgb(242,177,121));
    }

    public void showRect(){
        label.setVisible(false);
        label.setColor(Color.BLUE);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
