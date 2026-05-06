public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed=false;

    Trip(Passenger passenger,Driver driver,Location from,Location to,double basefare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
        completed=false;
        driver.setAvailable(false);

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
    public Location getTo() {
        return to;
    }
        public double getBaseFare(){
            return baseFare;
        }
    public boolean idCompleted(){
        return completed;
    }

    public  double getDistance(){
        return from.distance(to);
    }
    public double calculateFare(){
        return baseFare=baseFare+15.0*getDistance();
    }


}
