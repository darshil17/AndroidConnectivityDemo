package com.darshil.ormconnectivity;

/**
 * Created by Admin on 01-03-2023.
 */

public class User {
    private int id;
    private String nm;

    public User() {
    }

    public User(int id, String nm) {
        this.id = id;
        this.nm = nm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }
}
