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
    public int getId(){
        return id;
    }
    public Movie getmovie(){
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public int getStartHour() {
        return startHour;
    }

    public String getDateTag() {
        return dateTag;
    }
}
