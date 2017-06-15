package com.the.dionisio.apk.client.model.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.presenter.Presenter;
import com.the.dionisio.apk.client.model.view.fragments.GenreListAdapter;
import com.the.dionisio.apk.client.util.Util;
import java.util.Locale;

/**
 * Created by Daniel on 03/06/2017.
 */

public class Setting extends AppCompatActivity
{
    private Spinner optLanguage;
    private String[] aLanguage = new String[]{"Portuguese(Brazil)","English(United Stated)","Spain(Spain)"};
    private ListView listViewGenre;
    private GenreListAdapter adapterCustom;
    private Person person;
    private Token token;
    private EditText inputEmailSetting, inputNameSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_setting);

        optLanguage = (Spinner) findViewById(R.id.spLanguage);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, aLanguage);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        optLanguage.setAdapter(spinnerArrayAdapter);

        optLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        setLocale("br");
                        break;
                    case 2:
                        setLocale("en");
                        break;
                    case 3:
                        setLocale("es");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*listViewGenre = (ListView) findViewById(R.id.listViewGenre);

        adapterCustom = new GenreListAdapter(this);
        listViewGenre.setAdapter(adapterCustom);*/

        person = (Person) getIntent().getSerializableExtra("PERSON");
        token = (Token) getIntent().getSerializableExtra("TOKEN");

        inputEmailSetting = (EditText) findViewById(R.id.inputEmailSetting);
        inputNameSetting = (EditText) findViewById(R.id.inputNameSetting);

        inputEmailSetting.setText(person.email);
        inputNameSetting.setText(person.name);
    }

    public void putPerson(View view)
    {
        person.name = inputNameSetting.getText().toString();
        Presenter.loginAction.refreshTokenApi(token, person, null, this, Api.METHOD_PUT);
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, Setting.class);
        startActivity(refresh);
        finish();
    }

    public void backMenu(View view)
    {
        Util.moviment.backView(this);
    }
}
