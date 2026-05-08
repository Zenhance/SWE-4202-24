public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

public Trip(Passenger passenger, Driver driver, Location from, Location to, double
            baseFare){
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;
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

    public Location getTo(){
        return to;
    }

    public double getBaseFare(){
        return baseFare;
    }

    public boolean isCompleted(){
        return completed;
    }

    public double getDistance(){
        double distance = from.distanceTo(to);
        return distance;
    }

    public double calculateFare(){
        double distance = from.distanceTo(to);
        double fare = baseFare + 15*distance;
        return fare;
    }

    public void completeTrip(){
        completed = true;
        driver.setAvailable(true);
    }

    public String getSummary(){
      String check;
      if(completed)
           check = "COMPLETED";
      else check = "IN PROGRESS";
      String string;
      string = String.format("Trip Summary\n" + "  Passenger : %s\n" + "  Driver    : %s (%s)\n" + "  From      : %s\n" + "  To        : %s\n" + "  Distance  : %.2f km\n" + "  Fare      : BDT %.2f\n" + "  Status    : %s",
                passenger.getName(), driver.getName(), driver.getLicencePlate(), from.toString(), to.toString(),
                getDistance(), calculateFare(),check);
      return string;
    }

}
