package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;
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
    public Hall getHall(){

        return hall;
    }
    public int getStartHour(){

        return startHour;
    }
    public String getDateTag(){
        return dateTag;
    }
    public boolean isPeak() {
        if (startHour >= 18 && startHour <= 21)
            return true;
        else return false;
    }
    @Override
    public String toString(){
    String s;
    s=""+" Inception @ Hall 2 - "+getStartHour()+ ":00 (" + getDateTag() + ")";
    return s;
    }


}
