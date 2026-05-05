public class Trip {

    private Passenger passenger;
    private Driver driver;
    private Location from;
    private double baseFare;
    private boolean completed;


    Trip(Passenger passenger, Driver driver, Location from,
         Location to, double baseFare){
        completed = false;
        driver.setAvailable(false);
    }



}
