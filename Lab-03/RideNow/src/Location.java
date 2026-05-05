public class Location {

    private String label;
    private double x;
    private double y;

    Location(String label,double x,double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }

    Location(double x,double y){
        this.x=x;
        this.y=y;
        this.label="unknown";
    }
}
