package com.zhousl.sketchboard.shape;

import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

/**
 * Created by Administrator on 2016/12/29.
 */

public class LineShape extends ShapeImpl {

    public LineShape(PanelView view) {
        super(view);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setPathEffect(new CornerPathEffect(1000));
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
                mPath.reset();
                mPath.moveTo(preX,preY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.rQuadTo((x-preX)/3,(y-preY)/3,(x-preX)*2/3,(y-preY)*2/3);
                mPath.rQuadTo((x-preX)/6,(y-preY)/6,(x-preX)/6,(y-preY)/6);
                mCanvas.drawPath(mPath,mPaint);
                invalidate();
                preX=x;
                preY=y;
                break;
            case MotionEvent.ACTION_UP:
                invalidate();
                break;
        }
        return true;
    }
}
