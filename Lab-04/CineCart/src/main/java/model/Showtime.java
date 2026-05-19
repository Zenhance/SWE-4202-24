package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;

    public Showtime (int id, Movie movie, Hall hall, int startHour, String dateTag){
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        if(startHour>=0 && startHour<24)
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

    public boolean isPeak(){
        if (startHour>17 && startHour<22) return true;
        return false;
    }

    public String getDateTag() {
        return dateTag;
    }

    public String toString(){
        String string = String.format("[T%d] %s @ Hall %d - %d:00 %s",id,movie.getTitle(),hall.getId(),dateTag);
        return string;

    }
}
