package model;

public class Showtime {
    int id;Movie movie;Hall hall;int startHour;String dateTag;
    Showtime(int id, Movie movie,Hall hall, int startHour,String dateTag){
        this.id=id;
        this.movie=movie;
        this.hall=hall;
        this.startHour=startHour;
        this.dateTag=dateTag;
    }
    int getId(){
        return id;
    }
    Movie getMovie(){
        return movie;
    }
    Hall hall(){
        return hall;
    }
    int getStartHour(){
        return startHour;
    }
    String getDateTag(){
        return dateTag;
    }
    boolean isPeak(){
        if(startHour>=18 && startHour<=21)return true;
        else return false;
    }
    public String toString(){
        return String.format("[T%d] %s @ Hall %d - %d:00 (%s)", id,movie.getTitle(),hall.getId(),startHour,dateTag);
    }
}
