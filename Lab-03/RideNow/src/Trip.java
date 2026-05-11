public class Trip {
    private Passenger passenger;
    private Driver    driver;
    private Location  from;
    private Location  to;
    private double  baseFare;
    private boolean   completed;

    public Trip(Passenger passenger, Driver driver, Location from, Location to,double baseFare){

        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;
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

    public Location getTo (){
        return to;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public boolean isCompleted() {
        return completed;
    }

    public double getDistance(){
        return from.distanceTo(to);
    }

    public double calculateFare(){
        return baseFare + 15.0 * getDistance();
    }

    public void completeTrip(){
        this.completed = true;
        driver.setAvailable(true);
    }

    public String getSummary(){
        String status;

        if(completed){
            status = "Completed";
        }else{
            status = "In Progress";
        }

        String Summary = "Trip summary\n" +
                "Passenger : " +passenger.getName() + "\n" +
                "Driver    : " +driver.getName() + "(" + driver.getLicencePlate() + ")\n" +
                "From      : " +from.toString() + "\n" +
                "To        : " +passenger.getName() + "\n" +
                "Distance  : " +
                "Fare      : " +
                "Status    : " + status;

        return Summary;
    }
}
