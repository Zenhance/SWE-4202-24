public class Location
{
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y)
    {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public Location(double x, double y)
    {
        this.x = x;
        this.y = y;
        this.label = "Unknown";
    }

    public String getLabel()
    {
        return this.label;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double distanceTo(Location other)
    {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    public String toString()
    {
        return String.format("%s (%.2f, %.2f)", label, x, y);
    }
}
