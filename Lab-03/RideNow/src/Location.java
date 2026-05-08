public class Location {
    private String label;
    private double x,y;
    Location(String label,double x, double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }
    Location(double x, double y){
        this.x=x;
        this.y=y;
    }
    public String getLabel(){
        return label;
    }
    public double getX(){
       return x;
    }
    public double getY(){
      return y;
    }
    public double distanceTo(Location other){
        double distance=Math.sqrt(((other.x-x)*(other.x-x))+((other.y-y)*(other.y-y)));
        return distance;
    }
    public String toString(){
        return String.format("%s (%0.2f, %0.2f)",label,x,y);
    }

}

