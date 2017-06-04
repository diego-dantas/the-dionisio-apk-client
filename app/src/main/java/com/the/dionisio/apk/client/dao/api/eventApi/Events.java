package com.the.dionisio.apk.client.dao.api.eventApi;

import com.the.dionisio.apk.client.model.dto.Event;
import java.io.Serializable;
import java.util.List;

/**
 * Created by igorm on 29/05/2017.
 */

public class Events implements Serializable
{
    private static final long serialVersionUID = 1;

    public List<Event> events;
}
