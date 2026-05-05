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



}
