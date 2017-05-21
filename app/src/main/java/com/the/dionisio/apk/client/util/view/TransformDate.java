package com.the.dionisio.apk.client.util.view;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igorm on 06/05/2017.
 */

public class TransformDate
{
    public List<Integer> getDateIntoList(Bundle bundle)
    {
        List<Integer> birth = new ArrayList<>();

        String[] date = bundle.getString("BIRTH").split("/");
        Integer day = Integer.parseInt(date[0]);
        Integer month = Integer.parseInt(date[1]);
        Integer year = Integer.parseInt(date[2]);

        birth.add(year);
        birth.add(month);
        birth.add(day);

        return birth;
    }

    public List<Integer> getDateIntoList(String dateBirth)
    {
        List<Integer> birth = new ArrayList<>();

        String[] date = dateBirth.split("/");
        Integer day = Integer.parseInt(date[0]);
        Integer month = Integer.parseInt(date[1]);
        Integer year = Integer.parseInt(date[2]);

        birth.add(year);
        birth.add(month);
        birth.add(day);

        return birth;
    }

    public String getDateIntoString(List<Integer> birth)
    {
        String convertBirth = "";

        try
        {
            for(int i = 2; i>=0; i--)
            {
                convertBirth += birth.get(i).toString();
                if(i>0)
                {
                    convertBirth += "/";
                }
            }
        }
        catch (Exception error)
        {
            return null;
        }


        return convertBirth;
    }
}
