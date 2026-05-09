public class Location
{
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y){
        this.label=label;
        this.x=x;
        this.y=y;

    }
    public Location(double x,double y){
        this.label="Unknown";
        this.x=x;
        this.y=y;
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
        return label+" ("+String.format("%.2f",x)+", "+String.format("%.2f", y)+")";
    }

}
