package model;

public class Showtime {
    int id;
    Movie m;
    Hall h;
    int startHour;
    String dateTag;

    public Showtime(int id, Movie m, Hall h, int startHour, String dateTag) {
        this.id=id;
        this.m=m;
        this.h=h;
        this.startHour=startHour;
        this.dateTag=dateTag;
    }
}
