public class location {
     private String label;
     private double x;
     private double y;

    public location(String label,double x,double y){
        this.label=label;
        this.x=x;
        this.y=y;
    }
    public location(double x,double y){
        this.x=x;
        this.y=y;
    }
    public String getLabel(){
        return label;
    }

}
