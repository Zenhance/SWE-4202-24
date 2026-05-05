public class Location {
    private String label;
    private double x;
    private double y;

    Location(String label, double x, double y){
      this.label = label;
      this.x = x;
      this.y = y;
    }
    Location(double x, double y){
       this.x = x;
       this.y = y;
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

    }
}
