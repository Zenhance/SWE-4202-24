public class Location {
    private String label;
    private double x;
    private double y;


    public Location(String label, double x, double y){
        this.label = label;
        this.x=x;
        this.y=y;

    }

    public String getLabel(){
        return label;
    }
    //getter banai
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }


}
