public class Location {
    private String label;
    private double x;
    private double y;
}
public Location(String x, double x , double y)
{
    this.label = label;
    this.x = x;
    this.y = y;
}
public Location(double x, double y)
{
       this.x=x;
       this.y=y;
}
public String getLabel()
{
    return this.label;
}
public double getX()
{
    return this.x;
}