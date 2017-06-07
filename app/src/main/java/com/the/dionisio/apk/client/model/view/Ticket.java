package com.the.dionisio.apk.client.model.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;

import static com.the.dionisio.apk.client.util.Util.qrCode;

/**
 * Created by Daniel on 03/06/2017.
 */

public class Ticket extends AppCompatActivity {
    String idTicket = "teste";
    ImageView ivCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_ticket);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivCode = (ImageView) findViewById(R.id.ivCode);
    }
    public void backMenu(View view)
    {
        Util.moviment.backView(this);
    }

    public void genQrCode(View view){
        qrCode.QrCodeGenerator(idTicket, ivCode);
    }
}
