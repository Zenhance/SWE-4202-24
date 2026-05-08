public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public boolean isCompleted() {
        return completed;
    }

    public double getDistance() {
        double distance = from.distanceTo(to);
        return distance;
    }

    public double calculateFare() {
        double fare=baseFare + 15.0 * from.distanceTo(to);
        return fare;
    }


}
