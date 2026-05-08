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


}