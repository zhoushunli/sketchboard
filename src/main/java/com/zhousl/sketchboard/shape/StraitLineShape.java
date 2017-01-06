package com.zhousl.sketchboard.shape;

import android.view.MotionEvent;

import com.zhousl.sketchboard.view.PanelView;

/**
 * Created by Administrator on 2016/12/30.
 */

public class StraitLineShape extends ShapeImpl {

    public StraitLineShape(PanelView view) {
        super(view);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
