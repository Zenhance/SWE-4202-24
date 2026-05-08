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
}