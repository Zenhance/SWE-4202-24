public class Trip {
    Passenger passenger;
    Driver driver;
    Location from;
    Location to;
    double baseFare;
    boolean completed;
    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
        this.completed=false;
        driver.setAvailable(false);
    }
}
