public class Location {
    String lebel;
    double x,y;
    Location(String lebel,double x, double y){
        this.lebel=lebel;
        this.x=x;
        this.y=y;
    }
    Location(double x, double y){
        this.x=x;
        this.y=y;
    }
    public String getlebel(String str){
        return str;
    }
    public double getx(double x){
       return x;
    }
    public double gety(double y){
      return y;
    }
    public double distanceTo(double x1,double y1){
        double distance=Math.sqrt(((x1-x)*(x1-x))+((y1-y)*(y1-y)));
        return distance;
    }
    public String toString(String lebel, double x, double y){
        return String.format(lebel,x,y);
    }

}

