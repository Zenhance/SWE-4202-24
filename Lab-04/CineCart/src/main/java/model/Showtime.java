package model;

public class Showtime {
    private int id;
    private Movie movie; // here, 'movie' includes everything the class 'Movie' holds
    private Hall hall; // here, 'hall' includes everything the class 'Hall' holds
    private int startHour;
    private String datetag;


    public Showtime(int id, Movie movie, Hall hall, int startHour, String datetag){
        this.id=id;
        this.movie=movie;
        this.hall=hall;
        this.startHour=startHour;
        this.datetag=datetag;
    }

    public int getId() {
        return id;
    }

    public Hall getHall() {
        return hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStartHour() {
        return startHour;
    }

    public String getDatetag() {
        return datetag;
    }


    public boolean isPeak(){
        if(startHour>=18 && startHour<=21){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return String.format("[T%d] %s @ Hall %d - %d:00 (%s)", id, movie.getTitle(),hall.getId(), startHour, datetag);
    }






}
