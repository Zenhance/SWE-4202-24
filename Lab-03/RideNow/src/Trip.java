class Trip
{
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    double baseFare;
    boolean completed;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare)
    {

    }

    public double calculateFare()
    {
        double fare=0;
        return fare;
    }

    public void completeTrip()
    {

    }

    public double getDistance()
    {
        double distance=0;
        return distance;
    }

    public String getSummary()
    {
        return "Trip Summary";
    }
}