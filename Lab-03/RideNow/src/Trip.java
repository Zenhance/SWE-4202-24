public class Trip {
    Passenger passenger;
 Driver driver;
 Location from;
 Location to;
 double baseFare;
 boolean completed=false;

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
     return from.distanceTo(to);
    }
    public double calculateFare(){
      double fare=baseFare+(15.0*from.distanceTo(to);
    }
    public void completeTrip(){
     driver.setAvailable(true);
    }
    public String getSummary(){

    }
}
