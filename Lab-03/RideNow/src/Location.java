public class Location {
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }

    public Location(double x, double y){
        this.x=x;
        this.y=y;
        this.label="Unknown";
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

    // i am now getting how this distanceTo method is working!
    /*SO, when we are passing the Location other, the 'other' object
     which is basically the co-ordinates of the second location,
     points to the x and y co-ordinates alongside the label. SO, we
     can access to the x and y co-ordinates using other.this
     cuz, other.x=this.x(b)=x;
          other.y=this.y(b)=y;  */

    public double distanceTo(Location other){
        double dx=other.x-this.x;
        double dy=other.y-this.y;
        return  Math.sqrt(dx*dx+dy*dy);
    }

    public  String toString(){
        String loc=label+"("+x+","+y+")";
        return loc;
    }

    //333





}

