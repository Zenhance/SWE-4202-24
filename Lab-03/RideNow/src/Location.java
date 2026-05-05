public class Location {
    private String label;
    double x;
    double y;

    public Location(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){
        this.x = x;
        this.y = y;
    }
}
