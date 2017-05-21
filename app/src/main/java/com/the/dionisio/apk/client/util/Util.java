package com.the.dionisio.apk.client.util;

import com.the.dionisio.apk.client.util.api.AddressAPI;
import com.the.dionisio.apk.client.util.view.BundlePerson;
import com.the.dionisio.apk.client.util.view.CardGenre;
import com.the.dionisio.apk.client.util.view.MovingActivity;
import com.the.dionisio.apk.client.util.view.TransformDate;
import com.the.dionisio.apk.client.util.verification.ValidationInput;

/**
 * Created by igorm on 14/04/2017.
 */

public interface Util
{
    MovingActivity moviment = new MovingActivity();
    CardGenre cardGenre = new CardGenre();
    AddressAPI addressApi = new AddressAPI();
    ValidationInput validationInput = new ValidationInput();
    TransformDate transformDate = new TransformDate();
    BundlePerson getBundle = new BundlePerson();
}
