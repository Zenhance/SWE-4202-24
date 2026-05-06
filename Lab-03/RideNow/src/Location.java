public class Location {
    private String label;
    private double x;
    private double y;
    Location(String label, double x, double y)
    {
        this.label=label;
        this.x=this.x;
        this.y=y;
    }
    Location(double x, double y)
    {
        label="Unknown";
        this.x=x;
        this.y=y;
    }
    String getLabel()
    {
        return label;
    }
    double getX()
    {
        return x;

    }
     public double getY(){ return y;
    }
     public double distanceTo(Location other){
        double ans= Math.pow((other.x-x),2);
        ans+=Math.pow((other.y-y),2);
        ans= Math.sqrt(ans);
        return ans;
    }
    public String toString(){
        return String.format("%s (%f, %f)", label,x,y);
    }

}
