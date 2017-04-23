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

    public void goClear(Context context, Class classDestiny, String name, String email, String img_url, String tipoLogin)
    {
        Intent intent = new Intent(context, classDestiny);
        intent.putExtra("NAME", name);
        intent.putExtra("EMAIL", email);
        intent.putExtra("IMG_URL", img_url);
        intent.putExtra("TIPO_LOGIN", tipoLogin);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
