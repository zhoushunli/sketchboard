package com.zhousl.sketchboard.shape;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import com.zhousl.sketchboard.interf.OnTouchEvent;
import com.zhousl.sketchboard.view.PanelView;

/**
 * Created by Administrator on 2016/12/29.
 */

public abstract class ShapeImpl implements Shape,OnTouchEvent{

    protected Paint mPaint;
    private int DEFAULT_STROKE_WIDTH = 10;
    private int DEFAULT_STROKE_COLOR = Color.RED;
    private Bitmap mBuffer;
    protected Canvas mCanvas;
    protected Path mPath;
    private View mView;

    public ShapeImpl(PanelView view) {
        mView=view;
        initPaint();
        initPath();
        setCacheCanvas(view.getCanvas(),view.getBuffer());
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(mBuffer,0,0,null);
        canvas.drawPath(mPath,mPaint);
    }

    private void initPath() {
        mPath=new Path();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(DEFAULT_STROKE_WIDTH);
        mPaint.setColor(DEFAULT_STROKE_COLOR);
    }

    private void setCacheCanvas(Canvas canvas,Bitmap buffer){
        mCanvas=canvas;
        mBuffer=buffer;
        mCanvas.setBitmap(mBuffer);
    }

    protected void invalidate(){
        mView.invalidate();
    }
    protected void resetPaint(){
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(DEFAULT_STROKE_WIDTH);
        mPaint.setColor(DEFAULT_STROKE_COLOR);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        mPaint.setPathEffect(null);
    }

    @Override
    public void erase(Shape shape) {

    }

    @Override
    public void edit(Shape shape) {

    }
}
