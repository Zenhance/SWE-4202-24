public class Location {
    private final String label;
    private final double x;
    private final double y;

    public Location(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y) {
        label = "Unknown";
        this.x = x;
        this.y = y;
    }
    public String getLabel(){
        return label;

    }
    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }
    public double distanceTo(Location Other){

        double distance =Math.sqrt(Math.pow(this.x-Other.x, 2)+Math.pow(this.y-Other.y, 2));
        return distance;
    }

    public String toString(){
        return String.format("%s (%.2f, %.2f)", label,x,y);
    }


}