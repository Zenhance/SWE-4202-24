package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;

   public Showtime(int id,Movie movie,Hall hall,int startHour,String dataTag){
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dataTag;

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
    public String getDateTag() {
        return dateTag;
    }

    public int getStartHour() {
        return startHour;
    }


   public boolean isPeak() {
        return startHour >= 18 && startHour <= 21;
    }
    @Override
    public String toString() {
        return "[T" + id + "] "
                + movie.getTitle()
                + " @ Hall "
                + hall.getId()
                + " - "
                + String.format("%02d:00", startHour)
                + " (" + dateTag + ")";
    }
}




