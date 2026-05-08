public class Location {
    private String label;
    double x;
    double y;

    public Location(String label, double x, double y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String getlabel(){
        return label;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public double Distanceto(Location other){
     double distancex= other.x-this.x;
     double distancey=other.y-this.y;
     return Math.sqrt(distancex*distancex+distancey*distancey);
    }
    public String tostring(){
        return String.format("%s(%.2f,%.2f)",label,x,y);
    }


}


