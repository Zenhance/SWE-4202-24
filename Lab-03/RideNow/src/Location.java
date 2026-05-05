public class Location {

    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y)){
        this.label = null;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y){
        this.label = "Unknown";
        this.x = x;
        this.y = y;
    }

    void getLabel(){
        System.out.println(label);
    }
    void getX(){
        System.out.println(x);
    }

    void getY(){
        System.out.println(y);
    }

    double distanceTo(){
        double z = Math.sqrt(());
    }

    String tostring(){
        String result
    }
}
