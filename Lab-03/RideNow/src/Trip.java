public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;
        driver.setAvailable(false);
    }

    public Passenger getPassenger(){
        return this.passenger;
    }
    public Driver getDriver(){
        return this.driver;
    }
    public Location getFrom(){
        return this.from;
    }
    public Location getTo(){
        return this.to;
    }
    public double getBaseFare(){
        return this.baseFare;
    }
    public boolean isCompleted(){
        return this.completed;
    }

    public double getDistance(){
        return from.distanceTo(to);
    }

    public double calculateFare(){
        double distance = getDistance();
        return this.baseFare+(15.0*distance);
    }

    public void completeTrip(){
        this.completed = true;
        driver.setAvailable(true);
    }

    public String getSummary(){
        String status=completed?"COMPLETED":"IN PROGRESS";
        return String.format(
                "Trip Summary\n"+
                "Passenger : %s\n"+
                "Driver    : %s (%s)\n"+
                "From      : %s\n)"+
                "To        : %s\n"+
                "Distance  : %.2f km\n"+
                "Fare      : BDT %.2f\n"+
                "Status    : %s",
                passenger.getName(),driver.getName(),driver.getLicencePlate(),
                from.toString(),to.toString(),getDistance(),calculateFare(),status);
    }
}
