package model;

public class Showtime {
     int id;
     Movie movie;
     Hall hall;
     int startHour ;
     String dateTag;
     public Showtime(int id, Movie movie, Hall hall, int startHour ,String dateTag){
         this.id=id;
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

    public String getDateTag() {
        return dateTag;
    }
    boolean isPeak(int startHour) {
        if (startHour >= 18 && startHour <= 21) {
            return true;
        }
        return false;
    }
    public String toString(){
        return "["+id+"] "+movie+" @ "+"Hall "+hall+" - "+startHour+" ("+dateTag+")";
    }


}
