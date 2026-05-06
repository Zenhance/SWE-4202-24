public class Location {

    private String label;
    private double x;
    private double y;


    public Location(String label, double x, double y) {

        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y) {
        this.label = "Unknown";
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return this.label;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distanceTo(Location other){

         double result=Math.sqrt(Math.pow(other.x-this.x,2)+Math.pow(other.y-this.y,2));
         return result;
    }

    public String toString(){

        String result=("%s (%.2f %.2f)",label,x,y;
        return result;
    }



}
