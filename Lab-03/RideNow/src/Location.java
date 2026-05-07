public class Location {
     private String label;
     private double x;
     private double y;

    public Location(String label,double x,double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }
    public Location(double x,double y){
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
        double finalX= other.x-this.x;
        double finalY= other.y-this.y;
        double distance =Math.sqrt(finalX*finalX+finalY*finalY);
         return distance;
    }
    public String toString(){
        return label+" ("+String.format("%.2f",x)+", "+String.format("%.2f",y)+")";
    }

}
