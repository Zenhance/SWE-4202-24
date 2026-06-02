package model;

public class Showtime {
    int id;
    Movie movie;
    Hall hall;
    int starHour;
    String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int starHour, String dateTag){
        this.id=id;
        this.movie=movie;
        this.hall=hall;
        this.starHour=starHour;
        this.dateTag=dateTag;
    }
    public int getId(){
        return id;
    }
    public Movie getMovie() {
        return movie;
    }
    public Hall getHall(){
        return  hall;
    }
    public int getStarHour(){
        return starHour;
    }
    public String getDateTag(){
        return dateTag;
    }

    public boolean isPeak(){
      if(starHour>=18&&starHour<=21){
          return true;
      }
      return false;
   }

   public String toString(){
        return "[T"+id+"] "+movie+" @ Hall "+hall+" - "+starHour+":00 ("+dateTag+")";
   }
}
