package com.zhousl.sketchboard.shape;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/30.
 */

public class StraitLineShape extends ShapeImpl {

    private ArrayList<PointF> pointFs;
    private final float DEFAULT_RADIUS = 10;

    public StraitLineShape(PanelView view) {
        super(view);
        pointFs = new ArrayList<>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (pointFs.size() < 2) {
                    pointFs.add(new PointF(x, y));
                }
                break;
            case MotionEvent.ACTION_MOVE:
                return false;
            case MotionEvent.ACTION_UP:
                if (pointFs.size() == 0) {
                    return false;
                }
                mPaint.setColor(Color.RED);
                mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                for (PointF pf : pointFs) {
                    mCanvas.drawCircle(pf.x, pf.y, DEFAULT_RADIUS, mPaint);
                }
                if (pointFs.size() == 2) {
                    mPath.reset();
                    mPath.moveTo(pointFs.get(0).x, pointFs.get(0).y);
                    for (PointF pf : pointFs) {
                        mPath.lineTo(pf.x, pf.y);
                    }
                    mCanvas.drawPath(mPath,mPaint);
                    pointFs.clear();
                }
                invalidate();
                break;
        }
        return true;
    }
}
