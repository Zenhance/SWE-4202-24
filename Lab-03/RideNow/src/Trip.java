public class Trip {
private final Passenger passenger;
private final Driver driver;
private final Location from;
    private final Location to;
private final double basefare;
private boolean completed=false;
    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.basefare=baseFare;
        completed=false;
        driver.setAvailable(false);
    }

    public boolean isCompleted() {
        return completed;
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
        return basefare;
    }
    public double getDistance(){
       return from.distanceTo(to);
    }
    public double calculateFare()
    {
        return basefare+15*getDistance();
    }
    public void completeTrip()
    {
        completed=true;
        driver.setAvailable(true);
    }
    String getSummary(){
      if(isCompleted())  {return String.format("Trip Summary\n\tPassenger : %s\n\tDriver : %s\n\tFrom : %s\n\tTo : %s\n\tDistance : %.2f km\n\tFare : BDT %.2f\n\tStatus : COMPLETED",passenger.getName(),driver.toString(),from.toString(),to.toString(),getDistance(),calculateFare());}
      else {return String.format("Trip Summary\n\tPassenger : %s\n\tDriver : %s\n\tFrom : %s\n\tTo : %s\n\tDistance : %.2f km\n\tFare : BDT %.2f\n\tStatus : IN PROGRESS",passenger.getName(),driver.toString(),from.toString(),to.toString(),getDistance(),calculateFare());}
    }
}
