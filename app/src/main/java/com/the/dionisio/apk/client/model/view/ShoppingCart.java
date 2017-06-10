package com.the.dionisio.apk.client.model.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.mercadopago.callbacks.Callback;
import com.mercadopago.core.MercadoPago;
import com.mercadopago.core.MerchantServer;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.model.ApiException;
import com.mercadopago.model.CheckoutPreference;
import com.mercadopago.model.DecorationPreference;
import com.mercadopago.model.Payment;
import com.mercadopago.util.JsonUtil;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.model.dto.Items;
import com.the.dionisio.apk.client.model.dto.Payer;
import com.the.dionisio.apk.client.model.dto.Preference;
import com.the.dionisio.apk.client.util.Util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart extends AppCompatActivity {

    static final String TAG = "mercadopago";
    static final String publicKey = "TEST-e207354b-53a0-4ab9-87ed-3150c598e690";
    Event event = new Event();

    private EditText edtQtdMan;
    private EditText edtQtdWoman;
    private EditText edtQtdOther;
    private CheckBox cbMan;
    private CheckBox cbWoman;
    private CheckBox cbOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_shopping_cart);

        edtQtdMan = (EditText) findViewById(R.id.edtQtdMan);
        edtQtdWoman = (EditText) findViewById(R.id.edtQtdWoman);
        edtQtdOther = (EditText) findViewById(R.id.edtQtdOther);
    }


    public void backDetailedEvent(View view)
    {
        Util.moviment.backView(this);
    }


    public void callCheckout(final View view) {

        event = (Event) getIntent().getSerializableExtra("EVENT");
        edtQtdMan.getText().toString();
    /*
        //Recebe os parametros para o checkout
        Map<String, Object> preferenceMap = new HashMap<>();
        preferenceMap.put("item_id", "50");
        preferenceMap.put("item_tile", event.name);
        preferenceMap.put("item_description", event.description);
        preferenceMap.put("item_picte_url", "http://onnels.com/wp-content/uploads/2014/08/fotos-de-ruivas-gostosas-semi-nuas-29.jpg");
        preferenceMap.put("item_category_id", "2");
        preferenceMap.put("item_quantity", "4");
        preferenceMap.put("item_currency_id", "BRL");
        preferenceMap.put("item_unit_price", new BigDecimal(35));
        preferenceMap.put("payer_name", "The Dionisio");
        preferenceMap.put("payer_email", "thedionisio@thedionisio.com");*/


        List<Items> itemses = new ArrayList<>();
        Items items = new Items();
        Items items1 = new Items();
        Payer payer = new Payer();
        Preference preference = new Preference();

        items.id = "300";
        items.title = "item 1 android";
        items.description = "android 2";
        items.category_id = "12";
        items.quantity = "3";
        items.currency_id = "BRL";
        items.unit_price = "45";
        items1.id = "300";
        items1.title = "item 2 android";
        items1.description = "android 2";
        items1.category_id = "12";
        items1.quantity = "3";
        items1.currency_id = "BRL";
        items1.unit_price = "45";
        payer.name = "Dantas";
        payer.email = "email@thedionisio.com";

        itemses.add(items);
        itemses.add(items1);
        preference.items = itemses;
        preference.payer = payer;

        Map<String, Object> preferenceMap = new HashMap<>();
        preferenceMap.put("preference", preference);


        Log.i(TAG, "Recebi os parametros ");

        // Envía para o servidor
        MerchantServer.createPreference(this, "http://192.168.0.18:8080",
                "/checkout", preferenceMap, new Callback<CheckoutPreference>() {

                    @Override
                    public void success(CheckoutPreference checkoutPreference) {
                        onCardStartButtonClicked(view, checkoutPreference);
                    }

                    @Override
                    public void failure(ApiException error) {
                        Log.e(TAG, "Erro no retorno " + error);
                    }
                });
    }

    public void onCardStartButtonClicked(View view, CheckoutPreference checkoutPreference) {


        DecorationPreference decorationPreference = new DecorationPreference();
        decorationPreference.setBaseColor("#ff4000");
        decorationPreference.enableDarkFont();

        //chamada do checkout do mercadopago
        new MercadoPago.StartActivityBuilder()
                .setActivity(this)
                .setPublicKey(publicKey)
                .setCheckoutPreferenceId(checkoutPreference.getId())
                .setDecorationPreference(decorationPreference)
                .startCheckoutActivity();
    }


    //Retorno do checkout do mercadopago
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {

        if (requestCode == MercadoPago.CHECKOUT_REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {


                Payment payment = JsonUtil.getInstance()
                        .fromJson(data.getStringExtra("payment"), Payment.class);
                TextView results = (TextView) findViewById(R.id.txtTitulo);

                if (payment != null) {
                    results.setText("PaymentID: " + payment.getId() +
                            " - PaymentStatus: " + payment.getStatus());
                } else {
                    results.setText("Erro Payment");
                }

            } else {
                if ((data != null) && (data.hasExtra("mpException"))) {
                    MPException mpException = JsonUtil.getInstance()
                            .fromJson(data.getStringExtra("mpException"), MPException.class);
                }
            }
        }
    }
}
