public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare; // a fixed per-trip charge in BDT.
    private boolean completed = false;  //starts as false.

    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        driver.setAvailable(false);
    }


}
