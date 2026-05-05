class Location
{
    private String label;
    private double x;
    private double y;

    public Location(String label, double x, double y)
    {
        this.label=label;
        this.x=x;
        this.y=y;
    }

    public Location(double x, double y)
    {
        this.x=x;
        this.y=y;
    }

    public String getLabel()
    {
        return label;
    }

    public double getX() {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double distanceTo()
    {
        double distance=0;
        return distance;
    }

    public String toString()
    {
        return "Airport (3.00,7,50)";
    }

}