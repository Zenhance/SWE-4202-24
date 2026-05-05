public class Passenger {
private int id;
private String name;
private double rating; // a number from 1.0 to 5.0

    Passenger(int id, String name, double rating){
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    Passenger(int id, String name){
        this.rating = 5.0;
        this.id = id;
        this.name = name;
    }

    //getters
    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getRating(){
        return rating;
    }

    //updateRating Method
    public void updateRating(double newRating){
        this.rating = newRating;
    }

//    public String toString(){
//
//    }

}
