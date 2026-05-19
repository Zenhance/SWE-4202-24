package model;
public class Showtime {
    int id,startHour;
    Movie movie;
    Hall hall;
    String dateTag;
    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag){

        this.id=id;
        this.dateTag=dateTag;
        this.startHour=startHour;

    }
    public boolean isPeak() {
        if (startHour >= 18 && startHour <= 21) {
            return true;
        } else
            return false;
    }
//    public String toString(){
//
//
//    }
    }
