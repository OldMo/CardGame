package com.android.cardgame.cardgame;
import android.app.AlertDialog;
import  android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jelen on 2015/4/26.
 */
public class MainGameView extends GameView {

    private final static int ROWS = 8;
    private final static int COLUMNS = 5;
    private List<PointF> allPoints = new ArrayList<PointF>();
    private List<Card> cards = new ArrayList<Card>();
    private  int index;
    private int level = 2;   //等级数与卡片数一致
    private int errorTimes = 0;
    private double costTime = 0;
    private long startTime,endTime;
    public MainGameView(Context context){
        super(context);
        start(level);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onTouchView(event.getX(),event.getY());
                return false;


            }
        });
    }

    public void onTouchView(float x,float y){
        for(Card c: cards){
            if(c.onTouchCard(x,y)){
                if(index == c.getNum()){
                    cards.remove(c);
                    getRoot().removeChild(c);

                    if(index == 1){
                        turnCard();
                    }
                    index++;
                    if(cards.size() <= 0){
                        endTime = System.currentTimeMillis();
                        costTime = (endTime - startTime) / 1000.0;
                        new AlertDialog.Builder(getContext()).setTitle("恭喜通关，用时:"+costTime+"s，出错:"+errorTimes+"次！现在进入下一关吗？")
                                .setIcon(android.R.drawable.ic_dialog_info)
                                .setPositiveButton("继续征战", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        level++;
                                       start(level);
                                    }
                                })
                                .setNegativeButton("再战一回", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        start(level);
                                    }
                                }).show();
                    }
                    draw();
                }else{
                    Toast.makeText(getContext(),"哎呦，不是这个哦",Toast.LENGTH_SHORT).show();
                    errorTimes++;
                }
                break;
            }

        }
    }

    public void turnCard(){
        for(Card c:cards){
            c.showRect();
        }
    }

    public void start(int cardSize){
        index = 1;
        getAllPoint();
        addCards(cardSize);
        startTime = System.currentTimeMillis();
        errorTimes = 0;
    }

    public void getAllPoint(){
        allPoints.clear();

        for(int i = 0; i < COLUMNS; i++){
            for(int j = 0; j < ROWS; j++){
                float x = i * ((Config.WIDTH) / COLUMNS);
                float y = j * ((Config.HEIGHT - 40) / (ROWS+1));
                allPoints.add(new PointF(x,y));
//                System.out.println("x:"+x+"-y:"+y);
            }
        }
    }

    public void addCards(int cardSize){
        PointF p;
        Card c;
        for(int i=1;i<=cardSize;i++){
            p = allPoints.remove((int)(Math.random()*allPoints.size()));

            c = new Card(i,Config.WIDTH / COLUMNS - 5 ,(Config.HEIGHT -40) / (ROWS+1) - 5);
            getRoot().addChild(c);
            c.setX(p.x);
            c.setY(p.y);
//            System.out.println("Config.WIDTH,Config.Height:" + "( " + Config.WIDTH + "," +Config.HEIGHT +")" );
//            System.out.println("card" + i + ":(" + p.x + "," + p.y + ")");
            cards.add(c);
        }
        draw();
    }
}
