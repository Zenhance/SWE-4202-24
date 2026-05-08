public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed=false;


    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
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

    public double calculateFare() {
        return baseFare + (15.0 * getDistance());
    }

    public void completeTrip() {
        completed = true;
        driver.setAvailable(true);
    }

    public String getSummary() {
        String status;

        if (completed) {
            status = "COMPLETED";
        } else {
            status = "IN PROGRESS";
        }

        return String.format(
                "Trip Summary\nPassenger : %s\nDriver : %s (%s)\nFrom : %s\nTo : %s\nDistance : %.2f km\nFare : BDT %.2f\nStatus : %s",
                passenger.getName(), driver.getName(), driver.getLicencePlate(), from.toString(), to.toString(), getDistance(), calculateFare(), status);
    }
}