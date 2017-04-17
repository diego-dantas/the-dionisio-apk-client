package com.the.dionisio.apk.client.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by igorm on 14/04/2017.
 */

public class MovingActivity
{
    public void back(Activity activity)
    {
        activity.finish();
    }

    public void go(Context context, Class classDestiny)
    {
        Intent intent = new Intent(context, classDestiny);
        context.startActivity(intent);
    }
}
