public class Location {

    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y)){
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



    }

    String tostring(){
        String result =
    }

    public double getX() {
        return x;
    }
}
