public class Trip {

    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    // Constructor
    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;

        // Driver becomes unavailable when trip starts
        driver.setAvailable(false);
    }

    // Getters
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

    // Delegation to Location class
    public double getDistance() {
        return from.distanceTo(to);
    }

    // Fare calculation
    public double calculateFare() {
        double distance = getDistance();
        return baseFare + 15.0 * distance;
    }

    // Complete trip
    public void completeTrip() {
        this.completed = true;
        driver.setAvailable(true); // driver becomes available again
    }

    // Summary
    public String getSummary() {
        String status = completed ? "COMPLETED" : "IN PROGRESS";

        return "Trip Summary\n"
                + "Passenger : " + passenger.getName() + "\n"
                + "Driver : " + driver.getName() + " (" + driver.getLicencePlate() + ")\n"
                + "From : " + from.toString() + "\n"
                + "To : " + to.toString() + "\n"
                + "Distance : " + String.format("%.2f", getDistance()) + " km\n"
                + "Fare : BDT " + String.format("%.2f", calculateFare()) + "\n"
                + "Status : " + status;
    }
}