package com.leniscamila.deezerapp.model;

public class Album {

    private String id;
    private String title;

    public Album(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Album(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
