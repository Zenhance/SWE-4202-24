public class Location{

    private String label;
    private double x;
    private double y;

    public Location(String label,double x, double y){
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){
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
        double x = other.getX();
        double y = other.getY();
        double dX = this.x - x;
        double dY = this.y -y;
        double distance = Math.sqrt(dX*dX + dY*dY);
        return distance;
    }

    public  String toString(){
        String string = String.format("%s(%.2f,%.2f)",label,x,y);
        return string;
    }


}




