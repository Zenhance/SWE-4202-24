package model;

public class Showtime {

    //fields
    int id;
    String name;
    Hall hall;
    int startHour;

    String dateTag;



    //constructors

    public Showtime(int id, String name, Hall hall, int startHour, String dateTag) {

        this.id = id;
        this.name = name;
        this.hall = hall;
        this.startHour = startHour;
        this.dateTag = dateTag;
    }

    //methods
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Hall getHall() {
        return this.hall;
    }

    public int getStartHour() {
        return this.startHour;

    }

    public String getDateTag() {
        return this.dateTag;
    }

    public boolean isPeak() {
        if (startHour>18 && startHour<21)
        {
            return true;
        }

        else return false;
    }

    public String toString() {
        String s = "[T " + getId() + "] " + getName() + " @ Hall " + getHall() + " - " + getStartHour() + " (" + getDateTag() + ")";

        return s;
    }


}