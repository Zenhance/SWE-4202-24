package model;

public class Showtime {
    private final int id;
    private final Movie movie;
    private final Hall hall;
    private final int startHour;
    private final String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag){
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
    public Hall getHall(){
        return this.hall;
    }
    public int getStartHour(){
        return this.startHour;
    }
    public String getDateTag(){
        return this.dateTag;
    }
    public boolean isPeak(){
        if(startHour>=18 && startHour<=21){
            return true;
        }
        return false;
    }
    public String toString(){
       return "[T"+id+"] "+movie.getTitle()+" @Hall "+hall+" - "+startHour+":00 "+"("+dateTag+")";
    }
}
