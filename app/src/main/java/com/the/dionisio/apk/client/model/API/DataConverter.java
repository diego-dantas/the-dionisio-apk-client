package com.the.dionisio.apk.client.model.API;

import android.util.Log;
import com.the.dionisio.apk.client.model.DTO.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dantas on 3/25/17.
 */

public class DataConverter {

    public static final String TAG = "TESTEAPI";



    public void getDataConverter(String id){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Call<CatalogAPI> requestCatalog = serviceAPI.getPeople(id);


        requestCatalog.enqueue(new Callback<CatalogAPI>() {
            @Override
            public void onResponse(Call<CatalogAPI> call, Response<CatalogAPI> response) {

                CatalogAPI catalogAPI = response.body();
                if(response.isSuccessful()){
                    for(Person p : catalogAPI.getPeoples()){
                        Log.i(TAG, String.format("%s: %s", p.name, p.email));
                        Log.i(TAG, "----------------------");

                    }
                }else{
                    Log.i(TAG, "ERRO NA DataConverter: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CatalogAPI> call, Throwable t) {

                Log.e(TAG, "Erro: " + t.getMessage());
            }
        });
    }
}
