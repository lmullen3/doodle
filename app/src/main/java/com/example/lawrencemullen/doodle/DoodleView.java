package com.example.lawrencemullen.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by lawrencemullen on 9/10/15.
 */


public class DoodleView extends View {

    public final static int DEFAULT_COLOR = 255;
    public final static int DEFAULT_WIDTH = 25;
    private ArrayList<Line> theLines;
    private int lineWidth = DEFAULT_WIDTH;

    private int alphaValue = DEFAULT_COLOR;
    private int redValue = DEFAULT_COLOR;
    private int greenValue = DEFAULT_COLOR;
    private int blueValue = DEFAULT_COLOR;

    private int lineColor = DEFAULT_COLOR;

    private float x1 = 0;
    private float y1 = 0;
    private float x2 = 0;
    private float y2 = 0;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        theLines = new ArrayList<Line>();

    }

    public void clearArray(){
        theLines.clear();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            x1 = event.getX();
            y1 = event.getY();
            x2 = x1;
            y2 = y1;

        } else {
            x1 = x2;
            y1 = y2;
            x2 = event.getX();
            y2 = event.getY();
        }
        theLines.add(new Line(x1, y1, x2, y2, lineWidth, lineColor));
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        for (Line line : theLines) {
            line.drawLine(canvas);
        }
        invalidate();
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setColor(int alpha, int red, int green, int blue) {
        this.alphaValue = alpha;
        this.redValue = red;
        this.greenValue = green;
        this.blueValue = blue;

        lineColor = Color.argb(alpha, red, green, blue);

    }

    public int getAlphaValue() {
        return alphaValue;
    }

    public int getRedValue() {
        return redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }


}
