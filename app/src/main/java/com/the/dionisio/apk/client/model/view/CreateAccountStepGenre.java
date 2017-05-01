package com.the.dionisio.apk.client.model.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;

/**
 * Created by igorm on 23/04/2017.
 */

public class CreateAccountStepGenre extends AppCompatActivity {

    private CardView cardElectronics, cardRock, cardSertanejo, cardPagode;
    private ImageView imgElectronics, imgRock, imgSertanejo, imgPagode;
    private View bgElectronic,bgRock, bgPagode, bgSertanejo;
    private TextView txtElectronics, txtRock, txtSertanejo, txtPagode;
    private String controlCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_create_account_step_genre);

        cardElectronics = (CardView) findViewById(R.id.cardElectronics);
        imgElectronics = (ImageView) findViewById(R.id.imgElectronics);
        txtElectronics = (TextView) findViewById(R.id.txtElectronics);
        bgElectronic = findViewById(R.id.bgElectronic);

        cardRock = (CardView) findViewById(R.id.cardRock);
        imgRock = (ImageView) findViewById(R.id.imgRock);
        txtRock = (TextView) findViewById(R.id.txtRock);
        bgRock = findViewById(R.id.bgRock);

        cardSertanejo = (CardView) findViewById(R.id.cardSertanejo);
        imgSertanejo = (ImageView) findViewById(R.id.imgSertanejo);
        txtSertanejo = (TextView) findViewById(R.id.txtSertanejo);
        bgSertanejo = findViewById(R.id.bgCountry);

        cardPagode = (CardView) findViewById(R.id.cardPagode);
        imgPagode = (ImageView) findViewById(R.id.imgPagode);
        txtPagode = (TextView) findViewById(R.id.txtPagode);
        bgPagode = findViewById(R.id.bgPagode);

        //this is filter in black color and opacity
        Util.alpha.setAlpha(bgElectronic);
        Util.alpha.setAlpha(bgRock);
        Util.alpha.setAlpha(bgPagode);
        Util.alpha.setAlpha(bgSertanejo);

        controlCheck = "NOT_CHECK";
        cardElectronics.setTag(controlCheck);
        cardRock.setTag(controlCheck);
        cardSertanejo.setTag(controlCheck);
        cardPagode.setTag(controlCheck);
    }

    public void backCreateAccountStepGenre(View v)
    {
        Util.moviment.back(this);
    }

    public void checkCard(View v)
    {
        //verify which CarView was clicked to selecting
        int idCard = v.getId();
        switch (idCard)
        {
            case R.id.cardElectronics:
                if(cardElectronics.getTag() == controlCheck)
                {
                    imgElectronics.setImageResource(R.drawable.ic_eletro_checked);
                    txtElectronics.setTextColor(Color.parseColor("#FFFFFF"));
                    cardElectronics.setTag("CHECKED");
                }
                else
                {
                    imgElectronics.setImageResource(R.drawable.ic_eletro_not_check);
                    txtElectronics.setTextColor(Color.parseColor("#A0FFFFFF"));
                    cardElectronics.setTag(controlCheck);
                }
                break;
            case R.id.cardRock:
                if(cardRock.getTag() == controlCheck)
                {
                    imgRock.setImageResource(R.drawable.ic_rock_checked);
                    txtRock.setTextColor(Color.parseColor("#FFFFFF"));
                    cardRock.setTag("CHECKED");
                }
                else
                {
                    imgRock.setImageResource(R.drawable.ic_rock_not_check);
                    txtRock.setTextColor(Color.parseColor("#A0FFFFFF"));
                    cardRock.setTag(controlCheck);
                }
                break;
            case R.id.cardSertanejo:
                if(cardSertanejo.getTag() == controlCheck)
                {
                    imgSertanejo.setImageResource(R.drawable.ic_sertanejo_checked);
                    txtSertanejo.setTextColor(Color.parseColor("#FFFFFF"));
                    cardSertanejo.setTag("CHECKED");
                }
                else
                {
                    imgSertanejo.setImageResource(R.drawable.ic_sertanejo_not_check);
                    txtSertanejo.setTextColor(Color.parseColor("#A0FFFFFF"));
                    cardSertanejo.setTag(controlCheck);
                }
                break;
            case R.id.cardPagode:
                if(cardPagode.getTag() == controlCheck)
                {
                    imgPagode.setImageResource(R.drawable.ic_pagode_checked);
                    txtPagode.setTextColor(Color.parseColor("#FFFFFF"));
                    cardPagode.setTag("CHECKED");
                }
                else
                {
                    imgPagode.setImageResource(R.drawable.ic_pagode_not_check);
                    txtPagode.setTextColor(Color.parseColor("#A0FFFFFF"));
                    cardPagode.setTag(controlCheck);
                }
                break;
        }
    }
}
