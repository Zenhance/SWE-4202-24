public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    public Trip(Passenger passenger,
                Driver driver,
                Location from,
                Location to,
                double baseFare) {

        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;

        this.completed = false;
        this.driver.setAvailable(false);
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
        double turboRate = 15.0;
        return baseFare + turboRate * getDistance();
    }

    public void completeTrip() {
        completed = true;
        driver.setAvailable(true);
    }

    public String getSummary() {

        String vibe = completed ? "COMPLETED" : "IN PROGRESS";

        return String.format(
                "Trip Summary\n" +
                        "Passenger: %s\n" +
                        "Driver: %s\n" +
                        "From: %s\n" +
                        "To: %s\n" +
                        "Distance: %.2f km\n" +
                        "Fare: BDT %.2f\n" +
                        "Status: %s",

                passenger.getName(),
                driver.getName() + " - " + driver.getLicencePlate(),
                from.getLabel(),
                to.getLabel(),
                getDistance(),
                calculateFare(),
                vibe
        );
    }
}