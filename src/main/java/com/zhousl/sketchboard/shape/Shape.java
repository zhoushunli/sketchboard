package com.zhousl.sketchboard.shape;

import android.graphics.Canvas;

/**
 * Created by Administrator on 2016/12/29.
 */

public interface Shape {
    void draw(Canvas canvas);
    void erase(Shape shape);
    void edit(Shape shape);
}
