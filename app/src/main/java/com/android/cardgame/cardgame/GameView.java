package com.android.cardgame.cardgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Jelen on 2015/4/26.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private  Container root;


    public GameView(Context context) {
        super(context);
        root = new Container();
        getHolder().addCallback(this);

    }

    public void draw(){
        Canvas canvas = getHolder().lockCanvas();
        if(canvas != null){
            canvas.drawColor(Color.rgb(187,173,160));
            root.draw(canvas);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    public Container getRoot(){
        return root;
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        draw();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
