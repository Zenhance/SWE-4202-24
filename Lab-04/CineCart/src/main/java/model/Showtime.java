package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;

    Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag){
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }
    public int getId(){
        return this.id;
    }
    public Movie getMovie(){
        return this.movie;
    }
    public
}
