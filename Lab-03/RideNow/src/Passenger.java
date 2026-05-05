public class Passenger {
    private int id;
    private String name;
    private double rating = 5.0;

    Passenger(int id, String name, double rating){
        this.id = id;
        this.name = name;
        this.rating = rating;
    }
    Passenger(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getRating(){
        return this.rating;
    }

    public void updateRating(double newRating){
        newRating = getRating();
    }
    public String toString(){
        return "Passenger" + "[" + id + "]" + name + " " + "(" + rating + ")";
    }
}
