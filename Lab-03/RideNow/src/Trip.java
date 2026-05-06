public class Trip  {
   private Passenger passenger;
   private Driver driver;
   private location from;
   private location to;
   private double baseFare;
   private boolean completed;
   double totalFare;
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
         totalFare= baseFare+15.0*getDistance();
        return totalFare;
    }
    void completeTrip(){
        if(this.completed){
            driver.setAvailable(true);
        }
    }
String getSummary(){
    System.out.println("Trip Summary");
    System.out.println("Passenger:"+passenger.getName());
    System.out.println("Driver   :"+driver.getName()+"("+driver.getLicensePlate()+")");
    System.out.println("From     :"+from.toString());
    System.out.println("To       :"+to.toString());
    System.out.println("Distance :"+getDistance());
    System.out.println("Fare     : BDT") + totalFare;
    if(isCompleted()){
        System.out.println("Status  :COMPLETED");
    }else{
        System.out.println("Status   :IN PROGRESS");
    }
}

}
