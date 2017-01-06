package com.zhousl.sketchboard.shape;

import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

/**
 * Created by Administrator on 2016/12/29.
 */

public class CircleShape extends ShapeImpl{

    public CircleShape(PanelView view) {
        super(view);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setPathEffect(new CornerPathEffect(100));
    }

    private float preX;
    private float preY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                preX=x;
                preY=y;
                mPath.moveTo(preX,preY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.reset();
                mPath.addCircle(preX,preY,Math.abs(x-preX), Path.Direction.CCW);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                mCanvas.drawPath(mPath,mPaint);
                invalidate();
                break;
        }
        return true;
    }
}
