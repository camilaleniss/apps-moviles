package com.leniscamila.deezerapp.model;

public class TopDeezer {

    private Track[] data;
    private int total;

    public TopDeezer(Track[] data, int total) {
        this.data = data;
        this.total = total;
    }

    public TopDeezer() {
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
