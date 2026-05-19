package model;

public class Showtime {
    int id;
    Movie movie;
    Hall hall;
    int starthour;
    String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int starthour, String dataTag){
        this.id=id;
        this.movie=movie;
        this.hall=hall;
        this.starthour=starthour;
        this.dateTag=dataTag;
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
    public int getStarthour(){
        return starthour;
    }
    public String getDateTag(){
        return dateTag;
    }

    public boolean isPeak(){
        if(starthour>=18 && starthour<=21){
            return true;
        }
        return false;
    }

    public String toString(){
        return String.format("[T%d] %s @ Hall 2 - %02d:00 (%s)",id,movie.getTitle(),starthour,dateTag);
    }
}
