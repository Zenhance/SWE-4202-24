public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
         this.passenger=passenger;
         this.driver=driver;
         this.from=from;
         this.to=to;
         this.baseFare=baseFare;
         this.completed=false;
         driver.setAvailable(false);
    }


    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public boolean isCompleted() {
        return completed;
    }


    public double getDistance(){
        double calculated_distance=from.distanceTo(to);
        return calculated_distance;
    }

    public double calculateFare(){
       //  fare=baseFare+15.0*calulated_distance;
    }

    public void completeTrip(){
        completed=true;
        driver.setAvailable(true);
    }

    public String getSummary(){
        String message;

    }






}
