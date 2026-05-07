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
}
