package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;

    public Showtime (int id, Movie movie, Hall hall, int startHour, String dateTag) {
        this.id = id;
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

    public boolean isPeak() {
        boolean status = false;
        if (startHour >= 18 && startHour <= 21) {
            status = true;
        }
        return status;
    }
    public String toString(){
        return "[T"+id+"]"+ movie.getTitle()+"@ Hall"+hall.getId()+"-"+startHour+":00"+"("+dateTag+")";
    }
}