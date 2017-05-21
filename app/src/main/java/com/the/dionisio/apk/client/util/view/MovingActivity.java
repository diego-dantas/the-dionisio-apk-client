package com.the.dionisio.apk.client.util.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.io.Serializable;
import java.util.List;

/**
 * Created by igorm on 14/04/2017.
 */

public class MovingActivity
{
    public void backView(Activity activity)
    {
        activity.finish();
    }


    public void goView(Context context, Class classDestiny, List listEvent) {
        Intent intent = new Intent(context, classDestiny);
        intent.putExtra("ListEvent", (Serializable) listEvent);
        context.startActivity(intent);
    }

    public void goView(Context context, Class classDestiny)
    {
        Intent intent = new Intent(context, classDestiny);
        context.startActivity(intent);
    }

    public void goViewClearWithData(Context context, Class classDestiny, String name, String email, String password, String image_url, String birth, String sex)
    {
        Intent intent = new Intent(context, classDestiny);
        intent.putExtra("NAME", name);
        intent.putExtra("EMAIL", email);
        intent.putExtra("IMAGE_URL", image_url);
        intent.putExtra("PASSWORD", password);
        intent.putExtra("BIRTH", birth);
        intent.putExtra("SEX", sex);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void goViewClear(Context context, Class classDestiny)
    {
        Intent intent = new Intent(context, classDestiny);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
