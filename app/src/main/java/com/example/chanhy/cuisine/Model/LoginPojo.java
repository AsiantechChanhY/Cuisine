package com.example.chanhy.cuisine.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanhy on 23/05/2016.
 */
public class LoginPojo {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String passWord;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
