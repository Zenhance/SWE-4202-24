public class Location
{
    public String label;
    public double x;
    public double y;

    public Location(String label, int x, int y){
        this.label=label;
        this.x=x;
        this.y=y;

    }
    public Location(int x,int y){
        this.label="Unknown";
        this.x=x;
        this.y=y;
    }

}
