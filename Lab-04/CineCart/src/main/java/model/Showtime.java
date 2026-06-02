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


}