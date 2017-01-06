package com.zhousl.sketchboard.shape;

import android.graphics.Path;
import android.graphics.PointF;
import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

/**
 * Created by Administrator on 2016/12/29.
 */

public class StarShape extends ShapeImpl {

    public StarShape(PanelView view) {
        super(view);
        resetPaint();
    }

    private float preX;
    private float preY;
    private int edgeCount=8;
    private PointF mCenter;
    private float mAngle= (float) (2*Math.PI/edgeCount);
    private float mStartAngle=mAngle/2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                preX = x;
                preY = y;
                mPath.moveTo(preX, preY);
                mCenter=new PointF(preX,preY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.reset();
                Path path = calculatePath(preX, preY, x, y);
                mPath.addPath(path);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                mCanvas.drawPath(mPath, mPaint);
                invalidate();
                break;
        }
        return true;
    }

    private Path calculatePath(float preX, float preY, float x, float y) {
        if (edgeCount<3){
            return null;
        }
        float radius=Math.abs(x-preX);
        Path path=new Path();
        path.moveTo((float) (mCenter.x+radius*Math.cos(mStartAngle)), (float) (mCenter.y+radius*Math.sin(mStartAngle)));
        for (int i = 1; i < edgeCount; i++) {
            path.lineTo((float) (mCenter.x+radius*Math.cos(mStartAngle+mAngle*i)), (float) (mCenter.y+radius*Math.sin(mStartAngle+mAngle*i)));
        }
        path.close();
        return path;
    }

    public void setEdgeCount(int edgeCount){
        this.edgeCount=edgeCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }
}
