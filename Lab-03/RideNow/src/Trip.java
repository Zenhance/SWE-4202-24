public class Trip {

    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    Trip(Passenger passenger, Driver driver, Location from, Location to, double
            baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;
        driver.setAvailable(false);
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
        //double distance = getFrom().distanceTo(to);

        return distance;
    }

    public double calculateFare() {
        double fare = baseFare + 15.0 * getDistance();

        return fare;
    }

    public void completeTrip() {
        completed = true;
        driver.setAvailable(true);
    }

    public String getSummary() {
        String string = String.format(
                "Trip Summary\n" +
                        "  %-10s: %s\n" +
                        "  %-10s: %s (%s)\n" +
                        "  %-10s: %s (%.2f, %.2f)\n" +
                        "  %-10s: %s (%.2f, %.2f)\n" +
                        "  %-10s: %.2f km\n" +
                        "  %-10s: BDT %.2f\n",
                "Passenger", getPassenger().getName(),
                "Driver",    getDriver().getName(), getDriver().getLicencePlate(),
                "From",      getFrom().getLabel(), getFrom().getX(), getFrom().getY(),
                "To",        getTo().getLabel(), getTo().getX(), getTo().getY(),
                "Distance",  getDistance(),
                "Fare",      calculateFare() );

        String flag;

        if(completed) {
            flag = String.format("  %-10s: %s", "Status", "COMPLETED");
        }
        else {
            flag = String.format("  %-10s: %s", "Status", "IN PROGRESS");
        }

        return string + flag;
    }
}