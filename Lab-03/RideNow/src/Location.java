public class Location {
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }

    public Location(double x, double y){
        this.x=x;
        this.y=y;
        this.label="Unknown";
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

    // i am not getting how this distanceTo method is working!
    public double distanceTo(Location other){
        int x1=this.x;
        int y1=this.y;
        int x2=this.other;
        int y2=this.other;
        ditance
    }





}
