package com.the.dionisio.apk.client.util.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igorm on 06/05/2017.
 */

public class TransformDate
{
    public List<Integer> getDateIntoList(String dateBirth)
    {
        List<Integer> convertedBirth = new ArrayList<>();

        try
        {
            String[] date = dateBirth.split("/");
            Integer day = Integer.parseInt(date[0]);
            Integer month = Integer.parseInt(date[1]);
            Integer year = Integer.parseInt(date[2]);


            convertedBirth.add(year);
            convertedBirth.add(month);
            convertedBirth.add(day);
        }
        catch (Exception error)
        {
            return null;
        }

        return convertedBirth;
    }

    public String getDateIntoString(List<Integer> birth)
    {
        String convertedBirth = "";

        try
        {
            for(int i = 2; i>=0; i--)
            {
                convertedBirth += birth.get(i).toString();
                if(i>0)
                {
                    convertedBirth += "/";
                }
            }
        }
        catch (Exception error)
        {
            return null;
        }

        return convertedBirth;
    }

    public String getDateAndHourIntoString(List<Integer> dateEvent)
    {
        String convertedDateEvent = "";

        try
        {
            if(dateEvent.get(2) < 10)
            {
                convertedDateEvent += "0" + dateEvent.get(2).toString() + "/";
            }
            else
            {
                convertedDateEvent += dateEvent.get(2).toString() + "/";
            }

            if(dateEvent.get(1) < 10)
            {
                convertedDateEvent += "0" + dateEvent.get(1).toString() + "/";
            }
            else
            {
                convertedDateEvent += dateEvent.get(1).toString() + "/";
            }

            convertedDateEvent += dateEvent.get(0).toString() + " ";

            if(dateEvent.get(3) < 10)
            {
                convertedDateEvent += "0" + dateEvent.get(3).toString() + ":";
            }
            else
            {
                convertedDateEvent += dateEvent.get(3).toString() + ":";
            }

            if(dateEvent.get(4) < 10)
            {
                convertedDateEvent += "0" + dateEvent.get(4).toString();
            }
            else
            {
                convertedDateEvent += dateEvent.get(4).toString();
            }
        }
        catch(Exception error)
        {
            return null;
        }

        return convertedDateEvent;
    }
}
