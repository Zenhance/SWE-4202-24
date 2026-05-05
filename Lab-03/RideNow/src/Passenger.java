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
        int id = this.id;
        return id;
    }

    public String getName(){
        String name = this.name;
        return name;
    }

    public double getRating(){
        double rating = this.rating;
        return rating;
    }

    public void updateRating(double newRating){
        rating = newRating;
    }

    public String toString(){
        String name = getName();
        int id = getId();
        double rating = getRating();

        String id_str = String.valueOf(id);
        String rating_str = String.format("%.2f", rating); // another reminder to read the problem statement with open eyes

        String output = "Passenger[";
        output = output.concat(id_str);
        output = output.concat("] ");
        output = output.concat(name);
        output = output.concat(" (");
        output = output.concat(rating_str);
        output = output.concat(")");

        return output;
    }
}
