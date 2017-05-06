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
        Util.cardGenre.setAlpha(bgElectronic);
        Util.cardGenre.setAlpha(bgRock);
        Util.cardGenre.setAlpha(bgPagode);
        Util.cardGenre.setAlpha(bgSertanejo);

        controlCheck = "NOT_CHECK";
        cardElectronics.setTag(controlCheck);
        cardRock.setTag(controlCheck);
        cardSertanejo.setTag(controlCheck);
        cardPagode.setTag(controlCheck);
    }

    public void backCreateAccountStepGenre(View v)
    {
        Util.moviment.backView(this);
    }

    public void checkCard(View v)
    {
        switch (v.getId())
        {
            case R.id.cardElectronics:
                Util.cardGenre.checkCard(v, cardElectronics, txtElectronics, imgElectronics, controlCheck);
                break;
            case R.id.cardRock:
                Util.cardGenre.checkCard(v, cardRock, txtRock, imgRock, controlCheck);
                break;
            case R.id.cardSertanejo:
                Util.cardGenre.checkCard(v, cardSertanejo, txtSertanejo, imgSertanejo, controlCheck);
                break;
            case R.id.cardPagode:
                Util.cardGenre.checkCard(v, cardPagode, txtPagode, imgPagode, controlCheck);
                break;
        }
    }
}