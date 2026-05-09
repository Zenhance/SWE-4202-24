public class Trip {

private Passenger passenger;
private Driver driver;
private Location from;
private Location to;
private double baseFare; // a fixed per-trip charge in BDT.
private boolean completed;

Trip (Passenger passenger, Driver driver, Location from, Location to, double baseFare){
    this.passenger = passenger;
    this.driver = driver;
    this.from = from;
    this.to = to;
    this.baseFare = baseFare;
    this.completed = false;
    this.driver.setAvailable(false);
}

public Passenger getPassenger(){
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

public double getBaseFare(){
    return baseFare;
}

public boolean isCompleted(){
    return completed;
}

public double getDistance(){
    return from.distanceTo(to);
}

    public double calculateFare(){
    double fare = baseFare + 15.0 * getDistance();
    return fare;
    }


}
