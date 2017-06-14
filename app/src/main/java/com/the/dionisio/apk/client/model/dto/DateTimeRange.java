package com.the.dionisio.apk.client.model.dto;

import java.io.Serializable;

/**
 * Created by igorm on 01/06/2017.
 */

public class DateTimeRange implements Serializable
{
    private static final long serialVersionUID = 1;

    public Integer[] start;
    public Integer[] end;

    public String getStart() {
        return treateDateTime(this.start);
    }

    public String getEnd() {
        return treateDateTime(this.end);
    }

    private String treateDateTime(Integer[] value)
    {
        int y = 0, M = 0, d = 0, h=0, m = 0;
        String  MM="", dd = "", hh = "", mm = "";
        try
        {
            if (value.length>=4)
            {
                y = value[0];
                M = value[1];
                d = value[2];
                h = value[3];
                m = value[4];
            }

            MM = addZero(M);
            dd = addZero(d);
            hh = addZero(h);
            mm = addZero(m);

        }
        catch (Exception e)
        {
            return "dd/MM/yyyy hh:mm";
        }
        return dd+"/"+MM+"/"+y +" | "+hh+":"+mm;
    }

    private String addZero(Integer value)
    {
        if (value<10)
        {
            return String.valueOf("0"+value);
        }
        else
        {
            return String.valueOf(value);
        }
    }
}
