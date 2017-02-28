package com.zhousl.sketchboard.shape;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/28.
 */

public class PolyLineShape extends ShapeImpl {

    private ArrayList<PointF> points;
    private final int DEFAULT_MAX_LINE=Integer.MAX_VALUE;
    private final int DEFAULT_RADIUS=10;
    private int maxLine=DEFAULT_MAX_LINE;

    public PolyLineShape(PanelView view) {
        super(view);
        points=new ArrayList<>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (points.size()<maxLine){
                    points.add(new PointF(x,y));
                }
                break;
            case MotionEvent.ACTION_UP:
                if (points.size()<=0)
                    return false;
                mPaint.setStyle(Paint.Style.FILL);
                mPaint.setColor(Color.RED);
                for (PointF point : points) {
                    mCanvas.drawCircle(point.x,point.y,DEFAULT_RADIUS,mPaint);
                }
                mPaint.setStyle(Paint.Style.STROKE);
                mPath.reset();
                mPath.moveTo(points.get(0).x,points.get(0).y);
                for (PointF point : points) {
                    mPath.lineTo(point.x,point.y);
                }
                mCanvas.drawPath(mPath,mPaint);
                invalidate();
                if (points.size()==maxLine){
                    points.clear();
                }
                break;
        }
        return true;
    }

    public void setMaxLine(int maxLine){
        if (maxLine<2)
            return;
        this.maxLine=maxLine;
    }
}
