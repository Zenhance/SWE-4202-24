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
    Passenger getPassenger(){
        return this.passenger;
    }
    Driver getDriver(){
        return this.driver;
    }
    location getFrom(){
        return this.from;
    }
    location getTo(){
        return this.to;
    }
    double busFare(){
        return this.baseFare;
    }
    boolean isCompleted(){
        return this.completed;
    }
    double getDistance(){
        return from.distanceTo(this.to);
    }
    double calculateFare(){
        return baseFare+15.0*getDistance();
    }
    void completeTrip(){
        if(this.completed){
            driver.setAvailable(true);
        }
    }

}
