public class Trip {

    // Composition: Trip HOLDS objects of other classes
    private final Passenger passenger;
    private final Driver    driver;
    private final Location  from;
    private final Location  to;
    private final double    baseFare;
    private boolean         completed;

    private static final double RATE_PER_KM = 15.0;

    public Trip(Passenger passenger, Driver driver,
                Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver    = driver;
        this.from      = from;
        this.to        = to;
        this.baseFare  = baseFare;
        this.completed = false;

        driver.setAvailable(false);
    }


    public Passenger getPassenger() { return passenger; }
    public Driver    getDriver()    { return driver; }
    public Location  getFrom()      { return from; }
    public Location  getTo()        { return to; }
    public double    getBaseFare()  { return baseFare; }
    public boolean   isCompleted()  { return completed; }


    // Delegation: ask Location objects to do the geometry
    public double getDistance() {
        return from.distanceTo(to);
    }


    public double calculateFare() {
        return baseFare + RATE_PER_KM * getDistance();
    }


    public void completeTrip() {
        this.completed = true;
        driver.setAvailable(true);
    }

    public String getSummary() {
        String status = completed ? "COMPLETED" : "IN PROGRESS";
        return String.format(
                "Trip Summary%n" +
                        "  Passenger : %s%n" +
                        "  Driver    : %s (%s)%n" +
                        "  From      : %s%n" +
                        "  To        : %s%n" +
                        "  Distance  : %.2f km%n" +
                        "  Fare      : BDT %.2f%n" +
                        "  Status    : %s",
                passenger.getName(),
                driver.getName(), driver.getLicencePlate(),
                from.toString(),
                to.toString(),
                getDistance(),
                calculateFare(),
                status
        );
    }
}