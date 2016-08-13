package com.megatronking.divider.view;

import android.graphics.Rect;

/**
 * The bounds of DividerDrawable.
 *
 * @author Megatron King
 */
public interface DividerBounds {

    /**
     * Control the size and position of divider with a recycled {@link Rect}.
     * We could change the original value of left, right, top, bottom and set the new
     * value to {@link Rect} and return it.
     *
     * @param rect The recycled {@link Rect} for object reuse, never be null.
     * @param left The original left value of divider.
     * @param top The original top value of divider.
     * @param right The original right value of divider.
     * @param bottom The original bottom value of divider.
     *
     * @return The recycled {@link Rect} with new values.
     */
    Rect getBounds(Rect rect, int left, int top, int right, int bottom);
}
