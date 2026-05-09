public class Location {
    private String label;
    private double x;
    private double y;

    Location(String label, double x, double y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    Location(double x, double y){
        this.label = "Unknown";
        this.x = x;
        this.y = y;
    }

    //getters

    public String getLabel(){
        return label;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }


    public double distanceTo(Location other){
        double distance_x = other.x - this.x;
        double distance_y = other.y - this.y;
        return Math.sqrt(distance_x * distance_x + distance_y * distance_y);
    }

    @Override
    public String toString(){
        return String.format("%s (%.2f, %.2f)", label, x, y);
    }

}
