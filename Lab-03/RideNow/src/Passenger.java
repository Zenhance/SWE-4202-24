import java.util.Formatter;

public class Passenger {
    int id;
    double rating;
    String name;
    Passenger(int id, String name, double rating){
        this.id=id;
        this.name=name;
        this.rating=rating;
    }
    Passenger(int id, String name){
        this.id=id;
        this.name=name;
        this.rating=5.0;
    }
}
