package model;

public class Showtime {
    private int id;
    private Movie m;
    private Hall h;
    private int startHour;
    private String dateTag;

    public Showtime(int id, Movie m, Hall h, int startHour, String dateTag) {
        this.id = id;
        this.m = m;
        this.h = h;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }

    public int getId() {
        return id;
    }

    public Hall getH() {
        return h;
    }

    public Movie getM() {
        return m;
    }

    public String getDateTag() {
        return dateTag;
    }

    public int getStartHour() {
        return startHour;
    }
}