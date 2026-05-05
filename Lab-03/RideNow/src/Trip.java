public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare; // a fixed per-trip charge in BDT.
    private boolean completed = false;  //starts as false.

    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {

        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.driver.setAvailable(false);
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

    public double getDistance() {
        Location from = getFrom();
        Location to = getTo();

        double distance = from.distanceTo(to);
        return distance;
    }
    

    public double calculateFare() {
        double fare = baseFare + (15.0 * getDistance());
        return fare;
    }

    void completeTrip() {
        completed = true;
        driver.setAvailable(true);
    }

    public String getSummary(){
        String out = "";
            out = out.concat("Trip Summary");
            out = out.concat("  Passenger : " + passenger.getName());
            out = out.concat("  Driver    : " + driver.getName() + " (" + driver.getLicencePlate() + ")");
            out = out.concat("  From      : " + from.toString());
            out = out.concat("  To        : " + to.toString());
            out = out.concat("  Distance  : " + getDistance() + " km");
            out = out.concat("  Fare      : " + "BDT " + calculateFare());
        if (completed == false)
            out = out.concat("  Status    : IN PROGRESS");
        else if (completed == true)
            out = out.concat("  Status    : COMPLETED");
        return out;
    }
    
}