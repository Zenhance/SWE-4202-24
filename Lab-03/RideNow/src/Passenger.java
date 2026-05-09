public class Passenger {
    private int id;
    private String name;
    private double rating;

    public Passenger(int id, String name, double rating){
        this.id=id;
        this.name=name;
        this.rating=rating;
    }
    public Passenger(int id, String name){
        this.rating=5.00;
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getRating(){
        return this.rating;
    }
    public void updateRating(double newRating){
        this.rating=newRating;
    }
    public String toString(){
        return "Passenger["+this.id+"] "+this.name+" ("+String.format("%.2f",this.rating)+")";
    }
}
