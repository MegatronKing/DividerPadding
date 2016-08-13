package com.megatronking.divider.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.megatronking.divider.R;


/**
 * Define divider based on LinearLayout.
 *
 * @author Megatron King
 */
public class DividerLinearLayout extends LinearLayout implements DividerBounds {

    private int mDividerPaddingLeft;
    private int mDividerPaddingRight;

    private int mDividerPaddingTop;
    private int mDividerPaddingBottom;

    public DividerLinearLayout(Context context) {
        this(context, null);
    }

    public DividerLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DividerLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DividerPadding, defStyle, 0);
        mDividerPaddingLeft = a.getDimensionPixelSize(R.styleable.DividerPadding_dividerPaddingLeft, 0);
        mDividerPaddingRight = a.getDimensionPixelSize(R.styleable.DividerPadding_dividerPaddingRight, 0);
        mDividerPaddingTop = a.getDimensionPixelSize(R.styleable.DividerPadding_dividerPaddingTop, 0);
        mDividerPaddingBottom = a.getDimensionPixelSize(R.styleable.DividerPadding_dividerPaddingBottom, 0);
        a.recycle();
    }

    @Override
    public void setDividerDrawable(Drawable divider) {
        if (divider != null) {
            divider = new DividerDrawable(divider, this);
        }
        super.setDividerDrawable(divider);
    }

    @Override
    public void setDividerPadding(int padding) {
        if (getOrientation() == VERTICAL) {
            mDividerPaddingLeft = mDividerPaddingRight = padding;
        } else {
            mDividerPaddingTop = mDividerPaddingBottom = padding;
        }
    }

    /**
     * Set padding displayed on left side of dividers.
     *
     * @param padding Padding value in pixels that will be applied to each end
     *
     * @see #setDividerDrawable(Drawable)
     * @see #getDividerPaddingLeft()
     */
    public void setDividerPaddingLeft(int padding) {
        mDividerPaddingLeft = padding;
    }

    /**
     * Get the left padding size used to inset dividers in pixels
     *
     * @see #setDividerDrawable(Drawable)
     * @see #setDividerPaddingLeft(int)
     */
    public int getDividerPaddingLeft() {
        return mDividerPaddingLeft;
    }

    /**
     * Set padding displayed on right side of dividers.
     *
     * @param padding Padding value in pixels that will be applied to each end
     *
     * @see #setDividerDrawable(Drawable)
     * @see #getDividerPaddingRight()
     */
    public void setDividerPaddingRight(int padding) {
        mDividerPaddingRight = padding;
    }

    /**
     * Get the right padding size used to inset dividers in pixels
     *
     * @see #setDividerDrawable(Drawable)
     * @see #setDividerPaddingRight(int)
     */
    public int getDividerPaddingRight() {
        return mDividerPaddingRight;
    }


    /**
     * Set padding displayed on top side of dividers.
     *
     * @param padding Padding value in pixels that will be applied to each end
     *
     * @see #setDividerDrawable(Drawable)
     * @see #getDividerPaddingTop()
     */
    public void setDividerPaddingTop(int padding) {
        mDividerPaddingTop = padding;
    }

    /**
     * Get the top padding size used to inset dividers in pixels
     *
     * @see #setDividerDrawable(Drawable)
     * @see #setDividerPaddingTop(int)
     */
    public int getDividerPaddingTop() {
        return mDividerPaddingTop;
    }

    /**
     * Set padding displayed on bottom side of dividers.
     *
     * @param padding Padding value in pixels that will be applied to each end
     *
     * @see #setDividerDrawable(Drawable)
     * @see #getDividerPaddingBottom()
     */
    public void setDividerPaddingBottom(int padding) {
        mDividerPaddingBottom = padding;
    }

    /**
     * Get the bottom padding size used to inset dividers in pixels
     *
     * @see #setDividerDrawable(Drawable)
     * @see #setDividerPaddingBottom(int)
     */
    public int getDividerPaddingBottom() {
        return mDividerPaddingBottom;
    }

    @Override
    public Rect getBounds(Rect rect, int left, int top, int right, int bottom) {
        if (getOrientation() == VERTICAL) {
            left += mDividerPaddingLeft;
            right -= mDividerPaddingRight;
        } else {
            top += mDividerPaddingTop;
            bottom -= mDividerPaddingBottom;
        }
        rect.set(left, top, right, bottom);
        return rect;
    }
}
