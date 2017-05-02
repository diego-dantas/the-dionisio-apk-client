package com.the.dionisio.apk.client.util.utilView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by igorm on 15/04/2017.
 */

public class CardAlpha
{
    public View setAlpha(View view)
    {
        Drawable backgroundAlpha = view.getBackground();
        backgroundAlpha.setColorFilter(Color.BLACK, PorterDuff.Mode.LIGHTEN);
        backgroundAlpha.setAlpha(150);

        return view;
    }
}
