public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false; // completed is false before trip begins
        driver.setAvailable(false); // calling the setAvaiable() method
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
        return from.distanceTo(from);
    }

    public double calculateFare() {
        double distance = 0;
        double fare = baseFare + 15 * distance;
        return fare;
    }

    public void completeTrip() {

    }

    public String getSummary() {
        String summary = "Trip Summary\n" +
                "Passenger : Alice\n" +
                "Driver : Bob ( DHA -1234)\n" +
                "From : Airport (3.00 , 7.50)" +
                "To : University (8.00 , 4.00)\n" +
                "Distance : 6.10 km\n" +
                "Fare : BDT 141.50\n" +
                "Status : COMPLETED";
        return summary;
    }

}
