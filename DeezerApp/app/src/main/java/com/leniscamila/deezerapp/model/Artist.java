package com.leniscamila.deezerapp.model;

public class Artist {

    private String id;
    private String name;
    private String tracklist;

    public Artist(String id, String name, String tracklist) {
        this.id = id;
        this.name = name;
        this.tracklist = tracklist;
    }

    public Artist(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }
}
