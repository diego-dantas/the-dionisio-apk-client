package com.the.dionisio.apk.client.dao.api;

/**
 * Created by Dantas on 3/25/17.
 */

public class AddressAPI {

    private static final String BASE_URL = "http://192.168.0.13:4212/";

    public AddressAPI(){}

    public String getAddressAPI(){
        return this.BASE_URL;
    }

}
