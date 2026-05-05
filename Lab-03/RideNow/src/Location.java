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
    }

    public String getLabel() {
        return label;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double distance(Location p){
        double dx=p.x-this.x;
        double dy=p.y-this.y;
        return Math.sqrt((dx*dx)-(dy*dy));
    }

    public String toString(){

      return label+" "+"("+x+y+")";
    }


}
