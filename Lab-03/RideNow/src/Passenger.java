public class Passenger {
        private int id;
        private String name;
        double rating;

public Passenger(int id, String name, double rating){
    this.id = id;
    this.name = name;
    this.rating = rating;
}

public Passenger(int id,String name){
    this.id = id;
    this.name = name;
    rating = 5.0;
}

int getId(){
    return id;
}

String getName(){
    return name;
}

double getRating(){
    return rating;
}


}
