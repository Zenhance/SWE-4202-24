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
    return getDateTag();
}

public boolean isPeak(){

    if (startHour>=18 && startHour<=21){
        return true;
    else return false;
}

public String toString(){  //"[T17] Inception @ Hall 2 - 19:00 (Fri)".

        String res=String.format("[%d] %s @ Hall %d - %d (%s)",id,movie.getTitle(),hall.getID(),startHour,dateTag);

        return res;


    }
}
