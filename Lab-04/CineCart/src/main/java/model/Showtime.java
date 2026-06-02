package model;

public class Showtime {
    private int id;
    private Movie movie;
    private Hall hall;
    private int startHour;
    private String dateTag;
    public ShowTime(int id,Movie movie,Hall hall,int startHour,String dateTag){
      this.id=id;
      this.movie=movie;
      this.hall=hall;
      this.startHour=startHour;
      this.dateTag=dateTag;
    }
    public int getId(){
        return id;
    }
    public Movie getMovie(){
        return movie;
    }
    public Hall getHall(){
        return hall;
    }
public String getStartHour(){
        return dateTag;
}
public boolean isPeak() {
    return startHour >= 18 && startHour <= 21;
}
public String toString(){
        return "["+id+"]"+movie.getTitle()+" @Hall "+hall.getId()+" - "+String.format("%.02d:00",startHour)+"("+dateTag+")";
}
}
