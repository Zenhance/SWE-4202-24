package model;

public class Showtime {
    int id;
    Movie movie;
    Hall hall;
    int startHour;
    String dataTag;
    public Showtime(int id,Movie movie,Hall hall,int startHour,String dataTag){
        this.id=id;
        this.movie=movie;
        this.hall=hall;
        this.startHour=startHour;
        this.dataTag=dataTag;
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
    public int getStartHour(){
        return startHour;
    }
    public String getDataTag(){
        return dataTag;
    }
    public boolean isPeak(){
        return startHour>=18 && startHour<=21;
    }
    public String toString(){
        return "[T"+id+"]"+movie.getTitle()+"@ Hall "+hall.getId()+"-"+String.format("startHour")+
                "("+ dataTag+ ")";
    }

}
