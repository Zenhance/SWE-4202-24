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


    boolean isPeak() {
        if(startHour >= 18 && startHour <= 21){
            return true;
        }
        else{
        return false;}

    }

    @Override
    public String toString() {
        return "Showtime{" +
                "id=" + id +
                ", movie=" + movie +
                ", hall=" + hall +
                ", startHour=" + startHour +
                ", dateTag='" + dateTag + '\'' +
                '}';
    }
}




