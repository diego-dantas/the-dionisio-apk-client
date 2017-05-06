package com.the.dionisio.apk.client.util;

import com.the.dionisio.apk.client.util.utilApi.AddressAPI;
import com.the.dionisio.apk.client.util.utilView.CardGenre;
import com.the.dionisio.apk.client.util.utilView.MovingActivity;
import com.the.dionisio.apk.client.util.utilView.TransformDateIntoList;
import com.the.dionisio.apk.client.util.utilView.ValidationInput;

/**
 * Created by igorm on 14/04/2017.
 */

public interface Util
{
    MovingActivity moviment = new MovingActivity();
    CardGenre cardGenre = new CardGenre();
    AddressAPI addressApi = new AddressAPI();
    ValidationInput validationInput = new ValidationInput();
    TransformDateIntoList transformDate = new TransformDateIntoList();
}
