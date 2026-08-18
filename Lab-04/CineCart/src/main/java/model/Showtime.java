package model;

public class Showtime {
    int id;
    Movie movie;
    Hall hall;
    int startHour;
    String dateTag;

    public Showtime(int id, Movie movie, Hall hall, int startHour, String dateTag) {
       this.id = id;
       this.movie = movie;
       this.hall = hall;
       this.startHour = startHour;
       this.dateTag = dateTag;
    }
   public int getId(){
        return id;}

    public String getDateTag() {
        return dateTag;
    }

    public int getStartHour(){
        return startHour;}

    public Hall getHall(){return hall;}

    public Movie getMovie(){
        return movie;}

    public boolean isPeak() {
        if (startHour >= 18 && startHour <= 21) {
            return true;
        }
        return false;
    }
    public String toString() {
         return "[T" + id + "]" + movie.getName() + "@ Hall " + hall.getId() + "-" + dateTag;
    }
}

