package com.leniscamila.deezerapp.model;

public class Track {

    private String id;
    private String title;
    private String duration;
    private boolean explicit_lyrics;
    private int explicit_content_lyrics;

    private Artist artist;
    private Track track;

    public Track(String id, String title, String duration, boolean explicit_lyrics, int explicit_content_lyrics, Artist artist, Track track) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.explicit_lyrics = explicit_lyrics;
        this.explicit_content_lyrics = explicit_content_lyrics;
        this.artist = artist;
        this.track = track;
    }

    public Track(){

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isExplicit_lyrics() {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics(boolean explicit_lyrics) {
        this.explicit_lyrics = explicit_lyrics;
    }

    public int getExplicit_content_lyrics() {
        return explicit_content_lyrics;
    }

    public void setExplicit_content_lyrics(int explicit_content_lyrics) {
        this.explicit_content_lyrics = explicit_content_lyrics;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
