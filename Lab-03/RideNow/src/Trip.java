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

    public Passenger getPassenger(){
        Passenger p = this.passenger;
        return p;
    }
    public Driver getDriver(){
        Driver d = this.driver;
        return d;
    }
    public Location getFrom(){
        Location f = this.from;
        return f;
    }
    public Location getTo(){
        Location t =this.to;
        return t;
    }
    public double getBaseFare(){
        double b = baseFare;
        return b;
    }
    public boolean isCompleted(){
        boolean c = this.completed;
        return c;
    }

    double getDistance() {}
    

    double calculateFare() {}

    void completeTrip() {}

    String getSummary()
    
}