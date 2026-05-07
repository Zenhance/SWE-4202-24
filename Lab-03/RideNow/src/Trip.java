public class Trip  {
   private Passenger passenger;
   private Driver driver;
   private Location from;
   private Location to;
   private double baseFare;
   private boolean completed;
   double totalFare;
    Trip(Passenger passenger,Driver driver,Location from,Location to,double baseFare){
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
    Location getFrom(){
        return this.from;
    }
    Location getTo(){
        return this.to;
    }
    double getBaseFare(){
        return this.baseFare;
    }
    boolean isCompleted(){
        return this.completed;
    }
    double getDistance(){
        return from.distanceTo(this.to);
    }
    double calculateFare(){
         totalFare= baseFare+15.0*getDistance();
        return totalFare;
    }
    void completeTrip(){
       this.completed=true;
       driver.setAvailable(true);
    }
String getSummary(){
    return "Trip Summary\n"+"Passenger :"+passenger.getName()+"\n"+"Driver"+driver.getName()+" ("+driver.getLicencePlate()+")"+"\n"+"From   :"+from.toString()+"\n"
            +"To     :"+to.toString()+"\n"+"Distance  :"+getDistance()+"\n"+"Fare   :BDT "+calculateFare()+"TK"+"\n"+
            "Status  :"+(completed?"COMPLETED":"IN PROGRESS");

}

}
