public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed = false;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
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

    }

    public double calculateFare() {

    }

    public void completeTrip() {

    }

    public String getSummary() {
        return String.format("Trip Summary" +
                                "Passenger : %s" +
                                "Driver    : %s (%s)" +
                                "From      : %s (%.2f, %.2f)" +
                                "To        : %s (%.2f, %.2f" +
                                "Distance  : %.2f km" +
                                "Fare      : BDT %.2f" +
                                "Status    : %s",
                                 passenger.getName(), driver.getName(), driver.getLicencePlate(),
                                 from.getLabel(), from.getX(), from.getY(), to.getLabel(), to.getX()
                                 to.getY(), );
    }
}



