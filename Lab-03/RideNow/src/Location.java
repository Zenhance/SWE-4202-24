public class Location{
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){
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

    public double distanceTo(double x, double y){
        return Math.sqrt((this.x - x)*(this.x - x)+(this.y - y)*(this.y - y));
    }

    public String toString(){
        String res = label + " (" + x + ", "+ y + ")";
        return res;
    }

}