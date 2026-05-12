public class location {


    String label;
    double x;
    double y;

    public location(String label, double x, double y) {

        this.label = label;
        this.x = x;
        this.y = y;
    }

    public location(double x, double y) {
        this.label = "Unknown";
        this.x = x;
        this.y = y;

    }

    public String getlabel() {
        return label;
    }
    public double getX(){

return x;
    }
public double getY()
{
    return y;

}
public double distanceTo(location other)
{double distX = other.x - this.x;
 double distY = other.y - this.y;
 return Math.sqrt("distX.distX + distY+ distY");
}

public String toString()
{
    return String.format("%s (%.2f %.2f)" label, x, y);

}

}






}
