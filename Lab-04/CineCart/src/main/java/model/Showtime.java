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
    public Movie getMovie(){
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
    public boolean isPeak(){
        return startHour>=18 && startHour<=21;
    }
    public String toString(){
        return "["+id+"]"+movie+" @ "+hall+" - "+startHour+"("+dateTag+")";
    }
}
