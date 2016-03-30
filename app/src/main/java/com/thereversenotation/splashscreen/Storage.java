package com.thereversenotation.splashscreen;

/**
 * Created by bryan on 14/11/2015.
 */
public class Storage {
    int _id;
    String username, pass;

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getUserName() {
        return this.username;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getPass() {
        return this.pass;
    }

}