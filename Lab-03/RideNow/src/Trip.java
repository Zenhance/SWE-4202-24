public class Trip
{
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare)
    {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;
        driver.setAvailable(false);
    }

    public Passenger getPassenger()
    {
        return this.passenger;
    }

    public Driver getDriver()
    {
        return this.driver;
    }

    public Location getFrom()
    {
        return this.from;
    }

    public Location getTo()
    {
        return this.to;
    }

    public double getBaseFare()
    {
        return this.baseFare;
    }

    public boolean isCompleted()
    {
        return this.completed;
    }

    public double getDistance()
    {
        return from.distanceTo(to);
    }

    public double calculateFare()
    {
        return baseFare + 15.0 * getDistance();
    }


}