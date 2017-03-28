package com.the.dionisio.apk.client.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.the.dionisio.apk.client.R;

public class CreateAccountStepGenre extends AppCompatActivity {

    private ImageButton btnBackCreateGenre;
    private CardView cardCheck, cardElectronic, cardRock, cardSertanejo, cardPagode;
    private ImageView imgCheckElectronics, imgCheckRock, imgCheckSertanejo, imgCheckPagode;
    private View bgElectronic,bgRock, bgPagode, bgCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_create_account_step_genre);

        btnBackCreateGenre = (ImageButton) findViewById(R.id.btnBackCreateGenre);

        cardElectronic = (CardView) findViewById(R.id.cardElectronics);
        imgCheckElectronics = (ImageView) findViewById(R.id.imgCheckElectronics);

        cardRock = (CardView) findViewById(R.id.cardRock);
        imgCheckRock = (ImageView) findViewById(R.id.imgCheckRock);

        cardSertanejo = (CardView) findViewById(R.id.cardSertanejo);
        imgCheckSertanejo = (ImageView) findViewById(R.id.imgCheckSertanejo);

        cardPagode = (CardView) findViewById(R.id.cardPagode);
        imgCheckPagode = (ImageView) findViewById(R.id.imgCheckPagode);

        //I worked here! (byDaniel)
        //this is filter in black color and opacity is the setAlpha()

        //filter and opacity electronic genre
        View bgElectronic = findViewById(R.id.bgElectronic);
        Drawable backgroundElectronic = bgElectronic.getBackground();
        backgroundElectronic.setColorFilter(Color.BLACK, PorterDuff.Mode.LIGHTEN);
        backgroundElectronic.setAlpha(50);

        //filter and opacity rock genre
        View bgRock = findViewById(R.id.bgRock);
        Drawable backgroundRock = bgRock.getBackground();
        backgroundRock.setColorFilter(Color.BLACK, PorterDuff.Mode.LIGHTEN);
        backgroundRock.setAlpha(50);

        //filter and opacity pagode genre
        View bgPagode = findViewById(R.id.bgPagode);
        Drawable backgroundPagode = bgPagode.getBackground();
        backgroundPagode.setColorFilter(Color.BLACK, PorterDuff.Mode.LIGHTEN);
        backgroundPagode.setAlpha(50);

        //filter and opacity country genre
        View bgCountry = findViewById(R.id.bgCountry);
        Drawable backgroundCountry = bgCountry.getBackground();
        backgroundCountry.setColorFilter(Color.BLACK, PorterDuff.Mode.LIGHTEN);
        backgroundCountry.setAlpha(50);
    }

    public void backCreateGenre(View v){
        Intent itBackCreateGenre = new Intent(this, CreateAccount.class);
        itBackCreateGenre.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(itBackCreateGenre);
    }

    public void checkCard(View v){
        if(v == cardElectronic){
            if(imgCheckElectronics.getVisibility() == View.INVISIBLE){
                imgCheckElectronics.setVisibility(View.VISIBLE);
            } else{
                imgCheckElectronics.setVisibility(View.INVISIBLE);
            }
        } else if (v == cardRock){
            if(imgCheckRock.getVisibility() == View.INVISIBLE){
                imgCheckRock.setVisibility(View.VISIBLE);
            } else{
                imgCheckRock.setVisibility(View.INVISIBLE);
            }
        } else if(v == cardSertanejo){
            if(imgCheckSertanejo.getVisibility() == View.INVISIBLE){
                imgCheckSertanejo.setVisibility(View.VISIBLE);
            } else{
                imgCheckSertanejo.setVisibility(View.INVISIBLE);
            }
        } else if(v == cardPagode){
            if(imgCheckPagode.getVisibility() == View.INVISIBLE){
                imgCheckPagode.setVisibility(View.VISIBLE);
            } else{
                imgCheckPagode.setVisibility(View.INVISIBLE);
            }
        }

    }
}
