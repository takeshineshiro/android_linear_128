package com.medical.lepu.wirelessscan_ultrasound.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SeekBar;

/**
 * Created by wong on 11/16/16.
 */

public class VerticalSeekBar  extends SeekBar {


    public VerticalSeekBar(Context context) {
        super(context);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onSizeChanged(int w, int h, int oldwidth, int oldheight) {
        super.onSizeChanged(h, w, oldheight, oldwidth);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec,
                                          int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }


    protected void onDraw(Canvas c) {
        c.rotate(-90);
        c.translate(-getHeight(),0);
        super.onDraw(c);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:


            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                int i=0;
                i=getMax() - (int)(getMax() * event.getY() / getHeight());
                setProgress(i);
                Log.i("Progress",getProgress()+"");
                onSizeChanged(getWidth(),getHeight(), 0, 0);
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }







}







