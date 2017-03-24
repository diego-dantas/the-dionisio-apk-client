package com.the.dionisio.apk.client.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.the.dionisio.apk.client.R;

public class CreateAccountStepGenre extends AppCompatActivity {

    private ImageButton btnBackCreateGenre;
    private CardView cardElectronic, cardRock, cardSertanejo, cardPagode;
    private ImageView imgCheckElectronics, imgCheckRock, imgCheckSertanejo;

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
    }

    public void backCreateGenre(View v){
        Intent itBackCreateGenre = new Intent(this, CreateAccount.class);
        itBackCreateGenre.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(itBackCreateGenre);
    }

    public void checkCardElectronics(View v){
        if(imgCheckElectronics.getVisibility() == View.INVISIBLE){
            cardElectronic.setCardBackgroundColor(Color.argb(1,8,148,0));
            imgCheckElectronics.setVisibility(View.VISIBLE);
        } else{
            cardElectronic.setCardBackgroundColor(Color.WHITE);
            imgCheckElectronics.setVisibility(View.INVISIBLE);
        }
    }

    public void checkCardRock(View v){
        if(imgCheckElectronics.getVisibility() == View.INVISIBLE){
            cardRock.setCardBackgroundColor(Color.GREEN);
            imgCheckElectronics.setVisibility(View.VISIBLE);
        } else{
            cardRock.setCardBackgroundColor(Color.WHITE);
            imgCheckElectronics.setVisibility(View.INVISIBLE);
        }
    }

    public void checkCardSertanejo(View v){
        if(imgCheckElectronics.getVisibility() == View.INVISIBLE){
            cardSertanejo.setCardBackgroundColor(Color.rgb(8,148,0));
            imgCheckSertanejo.setVisibility(View.VISIBLE);
        } else{
            cardSertanejo.setCardBackgroundColor(Color.WHITE);
            imgCheckSertanejo.setVisibility(View.INVISIBLE);
        }
    }
}
