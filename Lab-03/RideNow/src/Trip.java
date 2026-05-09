public class Trip {

    //fields
    private Passenger passenger;
    private Driver driver;

    private Location from;
    private Location to;

    private double baseFare;
    private boolean completed = false;


    //constructor
    public Trip(Passenger passenger, Driver driver, Location from, Location to, double
            baseFare) {

        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;

    }
}