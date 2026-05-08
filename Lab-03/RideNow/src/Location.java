public class Location {
    private String label;
    private double x;
    private double y;

    //full constructor
    public Location(String label,double x,double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    //convenience constructor
    public Location(double x,double y) {
        this.label = "Unknown";
        this.x = x;
        this.y = y;
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
        double xx=other.x-this.x;
        double yy=other.y-this.y;
        return Math.sqrt(xx*xx + yy*yy);
    }

    public String toString(){
        return String.format("%s (%.2f, %.2f)", label, x, y);
    }
        }
