public class Location {
    public  String label;
    public double x;
    public double y;
    public Location(String label,double x,double y){
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
        return label;
    }
}
