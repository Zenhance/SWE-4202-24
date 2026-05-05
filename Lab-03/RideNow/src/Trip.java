public class Trip {

    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;


    Trip(Passenger passenger, Driver driver, Location from,
         Location to, double baseFare){
        completed = false;
        driver.setAvailable(false);
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver(){
        return driver;
    }

    public Location getFrom(){
        return from;
    }

    public Location getTo(){
        return to;
    }

    public boolean isCompleted() {
        return completed;
    }
}
