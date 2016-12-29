package com.zhousl.sketchboard.shape;

import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

/**
 * Created by Administrator on 2016/12/29.
 */

public class OvalShape extends ShapeImpl {
    public OvalShape(PanelView view) {
        super(view);
    }

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
                rectF.set(preX, preY, x, y);
                mPath.addOval(rectF, Path.Direction.CCW);
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
