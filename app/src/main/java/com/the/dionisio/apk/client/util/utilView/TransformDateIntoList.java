package com.the.dionisio.apk.client.util.utilView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igorm on 06/05/2017.
 */

public class TransformDateIntoList
{
    public List getDateIntoList(Bundle bundle)
    {
        List<Integer> birth = new ArrayList<>();

        String[] date = bundle.getString("BIRTH").split("/");
        Integer day = Integer.parseInt(date[0]);
        Integer month = Integer.parseInt(date[1]);
        Integer year = Integer.parseInt(date[2]);

        birth.add(day);
        birth.add(month);
        birth.add(year);

        return birth;
    }
}
