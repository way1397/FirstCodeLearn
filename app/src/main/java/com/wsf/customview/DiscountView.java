package com.wsf.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.wsf.firstcodelearn.R;


/**
 * 带锯齿边框的优惠券View
 */
public class DiscountView extends ConstraintLayout {
    private Paint mPaint;
    private int mLineColor;
    private int mTagColor;
    private TypedArray mTypedArray;

    public DiscountView(Context context) {
        super(context);
        initPaint();
    }

    public DiscountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.DiscountView);
        mLineColor = mTypedArray.getColor(R.styleable.DiscountView_line_color, Color.parseColor("#EEEEEE"));
        mTagColor = mTypedArray.getColor(R.styleable.DiscountView_tag_color, Color.parseColor("#EEEEEE"));
    }

    public void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        drawLine(canvas, height, width);
        drawTag(canvas, height, width);
    }
//fgfgfgfggf11122000
    private void drawLine(Canvas canvas, int height, int width) {
        //画大圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dip2px(getContext(), 1));
        mPaint.setColor(mLineColor);
        canvas.drawCircle(0, height * 9 / 25, dip2px(getContext(), 8), mPaint);
        canvas.drawCircle(width, height * 9 / 25, dip2px(getContext(), 8), mPaint);
        //画小圆
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(0, height * 9 / 25, dip2px(getContext(), 7), mPaint);
        canvas.drawCircle(width, height * 9 / 25, dip2px(getContext(), 7), mPaint);
        //画虚线
        mPaint.setStrokeWidth(dip2px(getContext(), 0.5f));
        mPaint.setColor(mLineColor);
        PathEffect pathEffect = new DashPathEffect(new float[]{10, 10}, 0);
        mPaint.setPathEffect(pathEffect);
        canvas.drawLine(dip2px(getContext(), 8), height * 9 / 25,
                getWidth() - dip2px(getContext(), 8), height * 9 / 25, mPaint);
        mPaint.setPathEffect(null);
    }

    private void drawTag(Canvas canvas, int height, int width) {
        //画右下角打勾标记
        Path path = new Path();
        mPaint.setColor(mTagColor);
        float tagWidth = dip2px(getContext(), 27);
        float tagHeight = dip2px(getContext(), 23);
        path.moveTo(getWidth() - tagWidth, getHeight());
        path.rLineTo(tagWidth - dip2px(getContext(), 5), 0);
        path.arcTo(width - dip2px(getContext(), 10), height - dip2px(getContext(), 10), getWidth(), getHeight(), 90, -90, false);
        path.rLineTo(0, -(tagHeight - dip2px(getContext(), 5)));
        path.close();
        canvas.drawPath(path, mPaint);
    }


    public void setLineColor(int color) {
        if (color != 0 && color == mLineColor) {
            return;
        }
        if (color != 0) {
            mLineColor = color;
        }
        invalidate();
    }

    public void setTagColor(int color) {
        if (color != 0 && color == mTagColor) {
            return;
        }
        if (color != 0) {
            mTagColor = color;
        }
        invalidate();
    }

    public int dip2px(Context context, float dipValue) {
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
    }
}
