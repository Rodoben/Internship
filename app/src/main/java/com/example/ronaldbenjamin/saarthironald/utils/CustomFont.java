package com.example.ronaldbenjamin.saarthironald.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomFont extends TextView {

    public CustomFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomFont(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Avenir-Black-webfont.ttf");
            setTypeface(tf);
        }
    }

}