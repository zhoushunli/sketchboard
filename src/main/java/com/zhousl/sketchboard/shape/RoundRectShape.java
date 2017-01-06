package com.zhousl.sketchboard.shape;

import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

/**
 * Created by Administrator on 2016/12/29.
 */

public class RoundRectShape extends ShapeImpl {
    public RoundRectShape(PanelView view) {
        super(view);
        resetPaint();
    }

    private float rx=5;
    private float ry=5;
    private float preX;
    private float preY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                preX = x;
                preY = y;
                mPath.moveTo(preX, preY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.reset();
                RectF rectF = new RectF();
                if (x>preX&&y>preY){
                    rectF.set(preX,preY,x,y);
                }
                if (x>preX&&y<preY){
                    rectF.set(preX,y,x,preY);
                }
                if (x<preX&&y<preY){
                    rectF.set(x,y,preX,preY);
                }
                if (x<preX&&y>preY){
                    rectF.set(x,preY,preX,y);
                }
                mPath.addRoundRect(rectF,rx,ry,Path.Direction.CCW);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                mCanvas.drawPath(mPath, mPaint);
                invalidate();
                break;
        }
        return true;
    }
}
