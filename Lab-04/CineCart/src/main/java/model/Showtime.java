package model;
public class Showtime {
    private final int id,startHour;
    private final Movie movie;
    private final Hall hall;
    private final String dateTag;
    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag){
        this.movie=movie;
        this.hall=hall;
        this.id=id;
        this.dateTag=dateTag;
        this.startHour=startHour;

    }

    public int getId() {
        return id;
    }

    public Hall getHall() {
        return hall;
    }

    public int getStartHour() {
        return startHour;

    }

    public Movie getMovie() {
        return movie;
    }

    public String getDateTag() {
        return dateTag;
    }

    public boolean isPeak() {
        if (startHour >= 18 && startHour <= 21) {
            return true;
        } else
            return false;
    }
    public String toString(){
    return "[T"+movie.getId()+"]"+" "+movie+"@ Hall"+hall.getId()+"-"+startHour+"("+dateTag+")";


    }
    }
