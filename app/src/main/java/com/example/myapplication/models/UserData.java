package com.example.myapplication.models;

public class UserData {
    private String name;
    private String surname;
    private String pass;
    private String mail;

    public UserData(String name, String surname, String mail, String paww) {
        this.name = name;
        this.surname=surname;
        this.pass = pass;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
