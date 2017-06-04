package com.the.dionisio.apk.client.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dantas on 3/25/17.
 */

public class Person implements Serializable
{
    private static final long serialVersionUID = 1;

    public String _id;
    public String name;
    public String email;
    public String password;
    public List<Integer> birth;
    public String cpf;
    public String picture;
    public String sex;
    public List<String> genres;
    public List<Card> card;
    public Boolean isActive;
}
