package model;

public class Showtime {
    int id;
    Movie m;
    Hall h;
    int startHour;
    String dateTag;

    public Showtime(int id, Movie m, Hall h, int startHour, String dateTag) {
        this.id=id;
        this.m=m;
        this.h=h;
        this.startHour=startHour;
        this.dateTag=dateTag;
    }

    public int getId() {
        return id;
    }

    public Movie getM() {
        return m;
    }

    public Hall getH() {
        return h;
    }

    public int getStartHour() {
        return startHour;
    }

    public String getDateTag() {
        return dateTag;
    }
    public boolean isPeak(){
        if (startHour>=18&&startHour<=21)
            return true;
        else return false;
        }
     public String toString(){
        String statement ="["+id+"]"+" "+m.title+" @ Hall"+h.id+" - "+startHour+"("+dateTag+")";
        return statement;
         }
    }


