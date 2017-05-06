package com.the.dionisio.apk.client.model.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.dao.sqlite.PersonDAO;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.presenter.Presenter;
import com.the.dionisio.apk.client.util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igorm on 23/04/2017.
 */

public class CreateAccountStepGenre extends AppCompatActivity {

    private CardView cardElectronics, cardRock, cardSertanejo, cardPagode;
    private ImageView imgElectronics, imgRock, imgSertanejo, imgPagode;
    private View bgElectronic,bgRock, bgPagode, bgSertanejo;
    private TextView txtElectronics, txtRock, txtSertanejo, txtPagode;
    private String controlCheck;
    private List<String> genres = new ArrayList<>();

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
                genres = Util.cardGenre.checkCard(v, cardElectronics, txtElectronics, imgElectronics, controlCheck, genres);
                break;
            case R.id.cardRock:
                genres = Util.cardGenre.checkCard(v, cardRock, txtRock, imgRock, controlCheck, genres);
                break;
            case R.id.cardSertanejo:
                genres = Util.cardGenre.checkCard(v, cardSertanejo, txtSertanejo, imgSertanejo, controlCheck, genres);
                break;
            case R.id.cardPagode:
                genres = Util.cardGenre.checkCard(v, cardPagode, txtPagode, imgPagode, controlCheck, genres);
                break;
        }
    }

    public void finalize(View v)
    {
        Bundle bundle = getIntent().getExtras();

        Person person = new Person();
        person.name = bundle.getString("NAME");
        person.email = bundle.getString("EMAIL");
        person.password = bundle.getString("PASSWORD");
        person.birth = Util.transformDate.getDateIntoList(bundle);
        person.sex = bundle.getString("SEX");
        person.genres = genres;

        Presenter.personAction.createPerson(person);

        PersonDAO personDAO = new PersonDAO(this);
        personDAO.createPerson(person, this);

    }
}
