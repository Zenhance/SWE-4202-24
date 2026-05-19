package model;

public class Showtime {
    public int id;
    public Movie movie;
    public Hall hall;
    public int startHour;
    public String dateTag;
    public Showtime(int id,Movie movie,Hall hall,int startHour,String dateTag){
        this.id=id;
        this.movie=movie;
        this.hall=hall;
        this.startHour=startHour;
        this.dateTag=dateTag;
    }
}
