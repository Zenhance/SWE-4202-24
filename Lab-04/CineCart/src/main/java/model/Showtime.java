package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;
    public Showtime(int id, Movie movie, Hall hall1, int startHour, String dateTag){
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }
    public int getId() {
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
    public boolean isPeak(){
        return startHour>=18 && startHour<=21;
    }
    @Override
    public String toString(){
        String hour = startHour<10? "0" + startHour : String.valueOf(startHour);
        return "[T" + id + "] " + movie.getTitle() + " @ Hall" + hall.getId() + " - " + hour + ":00 (" + dateTag + ")";
    }
}
