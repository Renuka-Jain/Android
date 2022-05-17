package com.example.myapplication.models;

public class User {
    private String name;
    private String surname;
    private String mail;
    private String pass;

    public User(String name, String surname, String mail, String pass) {
        this.name = name;
        this.surname=surname;
        this.mail=mail;
        this.pass=pass;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getPass() {
        return pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
