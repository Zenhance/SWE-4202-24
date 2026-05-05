public class Passenger {
   private int id;
   private String name;
   private double rating;

    public Passenger(int id, String name, double rating){
        System.out.println("Passenger " +"[" + id+"]"+name+"("+rating+")" );
    }
    public Passenger(int id, String name){
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public double getRating(){
        return rating ;
    }

    public void updateRating(double newRating){
        this.rating = newRating;
    }
    public String toString(){
        return name;
    }
}
