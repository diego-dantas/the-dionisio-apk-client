package com.the.dionisio.apk.client.model.API;

import android.util.Log;

import com.the.dionisio.apk.client.model.DTO.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dantas on 3/25/17.
 */

public class DataConverter {

    public static final String TAG = "TESTEAPI";



    public void getDataConverter(String id){

        ServiceAPI serviceAPI = ServiceGenerator.createService(ServiceAPI.class);
        Call<CatalogAPI> requestCatalog = serviceAPI.getPeople(id);

        requestCatalog.enqueue(new Callback<CatalogAPI>() {

            @Override
            public void onResponse(Call<CatalogAPI> call, Response<CatalogAPI> response) {

                CatalogAPI catalogAPI = response.body();
                if(response.isSuccessful()){
                    for(Person p : catalogAPI.getPeoples()){
                        Log.i(TAG, String.format("%s: %s", p.getName(), p.getEmail()));
                        Log.i(TAG, "----------------------");

                    }
                }else{
                    Log.i(TAG, "ERRO NA DataConverter: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CatalogAPI> call, Throwable t) {

                Log.e(TAG, "Erro AQUI: " + t.getMessage());
            }
        });
    }


    public void postDataConverter(Person p) {

        ServiceAPI serviceAPI = ServiceGenerator.createService(ServiceAPI.class);
        final Call<CatalogAPI> requestCatalog = serviceAPI.postPeople(p);

       requestCatalog.enqueue(new Callback<CatalogAPI>() {
            @Override
            public void onResponse(Call<CatalogAPI> call, Response<CatalogAPI> response) {

                if(response.isSuccessful()){
                    Log.i(TAG, "Deus certo");
                }else{
                    Log.e(TAG, "Deu merda: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CatalogAPI> call, Throwable t) {
                Log.e(TAG, "Erro: aqui " + t.getMessage());
            }
        });
    }
}
