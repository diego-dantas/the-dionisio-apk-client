package com.the.dionisio.apk.client.util.utilView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.the.dionisio.apk.client.R;

/**
 * Created by igorm on 15/04/2017.
 */

public class CardGenre
{
    public View setAlpha(View view)
    {
        Drawable backgroundAlpha = view.getBackground();
        backgroundAlpha.setColorFilter(Color.BLACK, PorterDuff.Mode.LIGHTEN);
        backgroundAlpha.setAlpha(150);

        return view;
    }

    public void checkCard(View v, CardView cardView, TextView textView, ImageView imageView, String controlCheck)
    {
        switch (v.getId())
        {
            case R.id.cardElectronics:
                if(cardView.getTag() == controlCheck)
                {
                    imageView.setImageResource(R.drawable.ic_eletro_checked);
                }
                else
                {
                    imageView.setImageResource(R.drawable.ic_eletro_not_check);
                }
                break;
            case R.id.cardRock:
                if(cardView.getTag() == controlCheck)
                {
                    imageView.setImageResource(R.drawable.ic_rock_checked);
                }
                else
                {
                    imageView.setImageResource(R.drawable.ic_rock_not_check);
                }
                break;
            case R.id.cardSertanejo:
                if(cardView.getTag() == controlCheck)
                {
                    imageView.setImageResource(R.drawable.ic_sertanejo_checked);
                }
                else
                {
                    imageView.setImageResource(R.drawable.ic_sertanejo_not_check);
                }
                break;
            case R.id.cardPagode:
                if(cardView.getTag() == controlCheck)
                {
                    imageView.setImageResource(R.drawable.ic_pagode_checked);
                }
                else
                {
                    imageView.setImageResource(R.drawable.ic_pagode_not_check);
                }
                break;
        }

        if(cardView.getTag() == controlCheck)
        {
            textView.setTextColor(Color.parseColor("#FFFFFF"));
            cardView.setTag("CHECKED");
        }
        else
        {
            textView.setTextColor(Color.parseColor("#A0FFFFFF"));
            cardView.setTag(controlCheck);
        }
    }
}
