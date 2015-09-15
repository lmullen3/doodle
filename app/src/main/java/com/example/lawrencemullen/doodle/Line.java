package com.example.lawrencemullen.doodle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by lawrencemullen on 9/10/15.
 */
public class Line {

    private float x1, y1, x2,y2;
    private int lineWidth;
    private Paint paint;
    private int lineColor;

    public Line(float firstX, float firstY, float secondX, float secondY,  int lineWidth, int givenColor) {
        this.x1 = firstX;
        this.y1 = firstY;
        this.x2 = secondX;
        this.y2 = secondY;
        this.lineWidth = lineWidth;
        this.lineColor = givenColor;

    }

    public void drawLine(Canvas canvas){
        paint = new Paint();
        paint.setColor(lineColor);
        paint.setStrokeWidth(lineWidth);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(x1, y1,x2,y2, paint);
    }
}
