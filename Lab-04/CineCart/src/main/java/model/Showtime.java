package model;

public class Showtime {
    int id;
    Movie movie;
    Hall hall;
    int starHour;
    String dataTag;

    public Showtime(int id, Movie movie, Hall hall, int starHour, String dataTag){
        this.id=id;
        this.movie=movie;
        this.hall=hall;
        this.starHour=starHour;
        this.dataTag=dataTag;
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
    public String getDataTag(){
        return dataTag;
    }


}
