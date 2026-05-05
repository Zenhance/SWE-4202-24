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

    String getLabel() {
        return label;
    }
    double getX(){
        return x;
    }
    double getY(){
        return y;
    }
    double distance(Location p){
        double dx=p.x-this.x;
        double dy=p.y-this.y;
        return Math.sqrt((dx*dx)-(dy*dy));
    }

    String ToString(){
      return String.format("%s (.2f,.2f)",label,x,y);

    }


}
