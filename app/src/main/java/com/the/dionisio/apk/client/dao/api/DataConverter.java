package com.the.dionisio.apk.client.dao.api;

import android.util.Log;

import com.the.dionisio.apk.client.model.dto.Person;

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
                    for(Person person : catalogAPI.getPeoples()){
                        Log.i(TAG, String.format("%s: %s", person.name, person.email));
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


    public void postDataConverter(Person person) {

        ServiceAPI serviceAPI = ServiceGenerator.createService(ServiceAPI.class);
        Call<CatalogAPI> requestCatalog = serviceAPI.postPeople(person);

       requestCatalog.enqueue(new Callback<CatalogAPI>() {
            @Override
            public void onResponse(Call<CatalogAPI> call, Response<CatalogAPI> response) {

                if(response.isSuccessful()){
                Log.i(TAG, "Deus certo, code: " + response.code());
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

    public void deleteDataConverter(String id) {

        ServiceAPI serviceAPI = ServiceGenerator.createService(ServiceAPI.class);
        Call<CatalogAPI> requestCatalog = serviceAPI.deletePerson(id);
        Log.i(TAG, "Chamei o metodo");
        requestCatalog.enqueue(new Callback<CatalogAPI>() {
            @Override
            public void onResponse(Call<CatalogAPI> call, Response<CatalogAPI> response) {

                if(response.isSuccessful()){
                    Log.i(TAG, "Deus certo METODO DELETE");
                }else{
                    Log.e(TAG, "Deu merda: DELETE" + response.code());
                }
            }

            @Override
            public void onFailure(Call<CatalogAPI> call, Throwable t) {
                Log.e(TAG, "Erro: aqui " + t.getMessage());
            }
        });
    }

    public void updateDataConverter(Person person) {

        ServiceAPI serviceAPI = ServiceGenerator.createService(ServiceAPI.class);
        Call<CatalogAPI> requestCatalog = serviceAPI.updatePerson(person);

        requestCatalog.enqueue(new Callback<CatalogAPI>() {
            @Override
            public void onResponse(Call<CatalogAPI> call, Response<CatalogAPI> response) {

                if(response.isSuccessful()){
                    Log.i(TAG, "Deus certo METODO de update");
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
