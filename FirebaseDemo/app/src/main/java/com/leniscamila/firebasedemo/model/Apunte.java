package com.leniscamila.firebasedemo.model;

public class Apunte {

    private String id;
    private String body;
    private long date;
    private String username;

    public Apunte(){
    }

    public Apunte(String id, String body, long date, String username) {
        this.id = id;
        this.body = body;
        this.date = date;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
