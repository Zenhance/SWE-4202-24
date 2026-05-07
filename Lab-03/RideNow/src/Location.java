public class Location {
    private String label;
    double x;
    double y;

    Location(String label, double x, double y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    Location(String label, double x, double y){
        this.label = "Unknown";
        this.x = x;
        this.y = y;
    }



}
