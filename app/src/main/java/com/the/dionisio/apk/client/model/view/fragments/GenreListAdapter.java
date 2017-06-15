package com.the.dionisio.apk.client.model.view.fragments;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by igorm on 15/06/2017.
 */

public class GenreListAdapter extends BaseAdapter
{
    private Context context;
    private CardView cardElectronicsGenre, cardRockGenre, cardSertanejoGenre, cardPagodeGenre;
    private ImageView imgElectronicsGenre, imgRockGenre, imgSertanejoGenre, imgPagodeGenre;
    private View bgElectronicGenre,bgRockGenre, bgPagodeGenre, bgSertanejoGenre;
    private TextView txtElectronicsGenre, txtRockGenre, txtSertanejoGenre, txtPagodeGenre;
    private String controlCheck;
    private List<String> genres = new ArrayList<>();

    public GenreListAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return 0;
    }

    @Override
    public Object getItem(int position)
    {
        return 0;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = View.inflate(context, R.layout.card_genre, null);

        cardElectronicsGenre = (CardView) view.findViewById(R.id.cardElectronics);
        imgElectronicsGenre = (ImageView) view.findViewById(R.id.imgElectronics);
        txtElectronicsGenre = (TextView) view.findViewById(R.id.txtElectronics);
        bgElectronicGenre = view.findViewById(R.id.bgElectronic);

        cardRockGenre = (CardView) view.findViewById(R.id.cardRock);
        imgRockGenre = (ImageView) view.findViewById(R.id.imgRock);
        txtRockGenre = (TextView) view.findViewById(R.id.txtRock);
        bgRockGenre = view.findViewById(R.id.bgRock);

        cardSertanejoGenre = (CardView) view.findViewById(R.id.cardSertanejo);
        imgSertanejoGenre = (ImageView) view.findViewById(R.id.imgSertanejo);
        txtSertanejoGenre = (TextView) view.findViewById(R.id.txtSertanejo);
        bgSertanejoGenre = view.findViewById(R.id.bgCountry);

        cardPagodeGenre = (CardView) view.findViewById(R.id.cardPagode);
        imgPagodeGenre = (ImageView) view.findViewById(R.id.imgPagode);
        txtPagodeGenre = (TextView) view.findViewById(R.id.txtPagode);
        bgPagodeGenre = view.findViewById(R.id.bgPagode);

        //this is filter in black color and opacity
        Util.cardGenre.setAlpha(bgElectronicGenre);
        Util.cardGenre.setAlpha(bgRockGenre);
        Util.cardGenre.setAlpha(bgPagodeGenre);
        Util.cardGenre.setAlpha(bgSertanejoGenre);

        controlCheck = "NOT_CHECK";
        cardElectronicsGenre.setTag(controlCheck);
        cardRockGenre.setTag(controlCheck);
        cardSertanejoGenre.setTag(controlCheck);
        cardPagodeGenre.setTag(controlCheck);

        return view;
    }

    public void checkCard(View v)
    {
        switch (v.getId())
        {
            case R.id.cardElectronics:
                genres = Util.cardGenre.checkCard(v, cardElectronicsGenre, txtElectronicsGenre, imgElectronicsGenre, controlCheck, genres);
                break;
            case R.id.cardRock:
                genres = Util.cardGenre.checkCard(v, cardRockGenre, txtRockGenre, imgRockGenre, controlCheck, genres);
                break;
            case R.id.cardSertanejo:
                genres = Util.cardGenre.checkCard(v, cardSertanejoGenre, txtSertanejoGenre, imgSertanejoGenre, controlCheck, genres);
                break;
            case R.id.cardPagode:
                genres = Util.cardGenre.checkCard(v, cardPagodeGenre, txtPagodeGenre, imgPagodeGenre, controlCheck, genres);
                break;
        }
    }
}
