public class Passenger {
    public int id;
    public String name;
    public double rating;

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


}
