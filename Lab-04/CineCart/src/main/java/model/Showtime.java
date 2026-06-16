package model;

public class Showtime {
    private double basePrice;
    private boolean peak;
    public Showtime(double basePrice,boolean peak){
        this.basePrice=basePrice;
        this.peak=peak;
    }

    //constructor
    public Showtime(int id, Movie movie,Hall hall, int startHour, String dateTag) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }

    //getters
    public int getId(){
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public int getStartHour() {
        return startHour;
    }

    public String getDateTag() {
        return dateTag;
    }

    public boolean isPeak() {
        return startHour >= 18 && startHour <= 21;
    }

    @Override
    public String toString() {
        return " [T" + id + "]" + movie.getTitle() + " @ Hall" + hall.getId() + " - " + String.format("%02d:00", startHour) + "(" + dateTag + ")";
    }
}


