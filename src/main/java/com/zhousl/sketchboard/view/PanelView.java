package com.zhousl.sketchboard.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zhousl.sketchboard.shape.LineShape;
import com.zhousl.sketchboard.shape.ShapeImpl;

/**
 * Created by Administrator on 2016/12/29.
 */

public class PanelView extends View {

    private ShapeImpl mShape;
    private Bitmap mBuffer;
    private Canvas mCanvas;

    public PanelView(Context context) {
        this(context, null);
    }

    public PanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCanvas=new Canvas();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mBuffer==null)
            mBuffer=Bitmap.createBitmap(getMeasuredWidth(),getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        mShape=new LineShape(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mShape.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mShape.onTouchEvent(event);
    }

    public void setShape(ShapeImpl shape){
        if (shape==null)
            return;
        mShape=shape;
    }

    public Canvas getCanvas() {
        return mCanvas;
    }

    public Bitmap getBuffer() {
        return mBuffer;
    }

    public ShapeImpl getShape(){
        return mShape;
    }
}
