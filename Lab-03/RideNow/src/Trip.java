public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed = false;

    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.driver.setAvailable(false);
    }

    public Passenger getPassenger(){
        return this.passenger;
    }
    public Driver getDriver(){
        return this.driver;
    }
    public Location getFrom(){
        return this.from;
    }
    public Location getTo(){
        return this.to;
    }
    public double getBaseFare(){
        return this.baseFare;
    }
    public boolean isCompleted(){
        return this.completed;
    }
    public double getDistance(){
        return from.distanceTo(to);
    }
    public double calculateFare(){
        return this.baseFare + 15.0 * getDistance();
    }
    public void completeTrip(){
        this.completed = true;
        driver.setAvailable(true);
    }
    public String getSummary(){
      String status = completed? "Completed" : "In Progress";
            return "Trip Summary\n" +
                    "Passenger :" + passenger.getName() + "\n" +
                    "Driver :" + driver.getName() + "(" + driver.getLicencePlate() + ")\n" +
                    "From :" + from.getLabel() + "(" + from.getX() + "," + from.getY() + ")\n" +
                    "To :" + to.getLabel() + "(" + to.getX() + "," + to.getY() + ")\n" +
                    "Distance :" + String.format("%.2f",getDistance()) + " km" + "\n" +
                    "Fare :" + String.format("BDT %.2f",calculateFare()) + "\n" +
                    "Status :" + status;
    }
}
