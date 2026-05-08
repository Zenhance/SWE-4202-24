public class Location {

    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y){
        this.label = null;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){
        this.label = "Unknown";
        this.x = x;
        this.y = y;
    }

    public getLabel(){

    return label;
    }

    public double getX(){

    return x;
    }

    public double getY(){

        return y;
    }

    public double distanceTo(Location other){

        double x = other.getX();
        double y = other.getY();

        double distance_k= Math.sqrt((this.x - x)*(this.x - x)+(this.y - y)*(this.y - y));

        return distance_k;

    }

    public String toString(){
        String string = String.format("%s (%.2f,%.2f), label, x, y") ;

        return string;
    }

}
