public class Location{
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(String label, double y){
        this.label = label;
        this.y = y;
    }

}