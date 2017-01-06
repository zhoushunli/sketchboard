package com.zhousl.sketchboard.shape;

import android.graphics.PointF;
import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/30.
 */

public class BezielShape extends ShapeImpl {

    private ArrayList<PointF> points;

    public BezielShape(PanelView view) {
        super(view);
        points=new ArrayList<>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            points.add(new PointF(event.getX(),event.getY()));
            return true;
        }
        return false;
    }
}
