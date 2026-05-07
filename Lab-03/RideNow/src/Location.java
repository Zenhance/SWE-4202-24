public class Location {
    String label;
    double x,y;
    Location(String label,double x, double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }
    Location(double x, double y){
        this.label="Unknown";
        this.x=x;
        this.y=y;
    }
    String getLabel(){
        return label;
    }
    double getX(){
        return x;
    }
    double getY(){
        return y;
    }
    double distanceTo(Location other){
        double a=other.x - this.x;
        double b=other.y - this.y;
        return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
    public String toString(){
        return String.format("%s (%.2f, %.2f)", label,x,y);
    }
}
