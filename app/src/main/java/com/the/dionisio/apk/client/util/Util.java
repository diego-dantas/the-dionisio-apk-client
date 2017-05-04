package com.the.dionisio.apk.client.util;

import com.the.dionisio.apk.client.util.utilApi.AddressAPI;
import com.the.dionisio.apk.client.util.utilView.CardAlpha;
import com.the.dionisio.apk.client.util.utilView.MovingActivity;
import com.the.dionisio.apk.client.util.utilView.ValidationInput;

/**
 * Created by igorm on 14/04/2017.
 */

public interface Util
{
    MovingActivity moviment = new MovingActivity();
    CardAlpha alpha = new CardAlpha();
    AddressAPI addressApi = new AddressAPI();
    ValidationInput validationInput = new ValidationInput();
}
