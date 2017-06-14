package com.the.dionisio.apk.client.model.view;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;
import com.the.dionisio.apk.client.util.view.QrCode;


/**
 * Created by Daniel on 03/06/2017.
 */

public class Ticket extends AppCompatActivity {
    String idTicket = "592df8e565bd903c75b5cdfc";
    ImageView ivCode;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_ticket);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        ivCode = (ImageView) findViewById(R.id.ivCode);
        new QrCode(idTicket,ivCode,size);

    }
    public void backMenu(View view)
    {
        Util.moviment.backView(this);
    }

}
