package model;

public class Showtime {
    int id;
    Movie movie;
    Hall hall;
    int starthour;
    String dataTag;

    public Showtime(int id, Movie movie, Hall hall, int starthour, String dataTag){
        this.id=id;
        this.movie=movie;
        this.hall=hall;
        this.starthour=starthour;
        this.dataTag=dataTag;
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
    public String getDataTag(){
        return dataTag;
    }

}
