public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare = 50;
    private boolean completed = false;

    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        completed = false;
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
        return from.distanceTo(to);
    }

    double fare;
    public double calculateFare() {
        return fare = baseFare + 15.0 * from.distanceTo(to);
    }

    public void completeTrip() {
        completed = true;
        driver.setAvailable(true);
    }

    public String getSummary() {
        String state;

        if (completed) {
            state = "COMPLETED";
        } else {
            state = "IN PROGRESS";
        }

        return String.format("Trip Summary\n" +
                        "Passenger\t: %s\n" +
                        "Driver\t: %s (%s)\n" +
                        "From\t: %s\n" +
                        "To\t: %s\n" +
                        "Distance\t: %.2f km\n" +
                        "Fare\t: BDT %.2f\n" +
                        "Status\t: %s",
                passenger.getName(), driver.getName(), driver.getLicencePlate(),
                from.toString(), to.toString(), getDistance(), calculateFare(), state
        );
    }
}