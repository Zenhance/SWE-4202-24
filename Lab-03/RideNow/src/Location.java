public class Location {
    private String label;
    private double x;
    private double y;
    public Location(String label, double x, double y){
        this.x=x;
        this.y=y;
        this.label=label;
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

    public double distanceTo(Location other){
    return Math.sqrt(Math.pow(this.x-other.x,2)+Math.pow(this.y-other.y,2));
    }

    public String toString(){
        return String.format("%s (%.2f, %.2f)", this.label, this.x, this.y);
    }
}
