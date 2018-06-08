package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

import java.io.Serializable;

/**
 * Created by Liam de Waal on 26-Apr-17.
 */
public class UserModel implements Serializable{

    //private String name, hobby, city;
    private String product, aantal_dagen, aantal_producten;
    private int id;

    /*public String getCity() {
        return city;
    }*/

    public String getProduct(){
        return product;
    }

    /*public void setCity(String city) {
        this.city = city;
    }*/

    public void setProduct(String product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public String getName() {
        return name;
    }*/

    public String getAantal_dagen() {
        return aantal_dagen;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    public void setAantal_dagen(String aantal_dagen) {
        this.aantal_dagen = aantal_dagen;
    }

    /*public String getHobby() {
        return hobby;
    }*/
    public String getAantal_producten() {
        return aantal_producten;
    }

    /*public void setHobby(String hobby) {
        this.hobby = hobby;
    }*/
    public void setAantal_producten(String aantal_producten) {
        this.aantal_producten = aantal_producten;
    }
}
