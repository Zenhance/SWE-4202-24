public class Trip  {
   private Passenger passenger;
   private Driver driver;
   private location from;
   private location to;
   private double baseFare;
   private boolean completed;
    Trip(Passenger passenger,Driver driver,location from,location to,double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
        this.completed=false;
        driver.setAvailable(false);
    }

}
