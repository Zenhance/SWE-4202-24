public class Location {
    private String label;
    double x;
    double y;

    Location(String label, double x, double y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    Location(double x, double y){
        this.x = x;
        this.y = y;
        this.label = "Unknown";
    }

    public String getLabel(){
        return this.label;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }


}
