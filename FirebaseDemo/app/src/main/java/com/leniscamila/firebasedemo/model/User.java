package com.leniscamila.firebasedemo.model;

public class User {

    private String id;
    private String nombre;

    public User() {
    }

    public User(String id, String nombre, long date) {
        this.id = id;
        this.nombre = nombre;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    private long date;
}
