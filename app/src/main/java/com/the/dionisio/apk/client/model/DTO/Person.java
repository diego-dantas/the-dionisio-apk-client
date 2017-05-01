package com.the.dionisio.apk.client.model.dto;

/**
 * Created by Dantas on 3/25/17.
 */



public class Person {

    private String _id;
    private String name;
    private String email;
    private String password;
    //private LocalDate birth;
   // private String cpf;
    //private String sex;
    //public List<String> genres;
    //public List<Card> card;
   // private Boolean isActive;


    public void set_id(String _id){ this._id = _id; }

    public String get_id(){ return  this._id; }

    public void setName(String name){ this.name = name; }

    public String getName(){ return  this.name; }

    public void setPassword(String password){ this.password = password; }

    public String getPassword(){ return  this.password; }

    public void setEmail(String email){ this.email = email; }

    public String getEmail(){ return  this.email; }

}
