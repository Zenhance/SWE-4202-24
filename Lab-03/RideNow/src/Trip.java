public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completeTrip;

    public Trip (Passenger passenger,Driver driver ,Location from, Location to,double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.completeTrip=false;
        this.baseFare=baseFare;
        driver.setAvailable(false);
    }
    public  double getDistance(){
        return from.distanceToLocation(to);
    }
    public void setCompleted(){
        this.completeTrip=true;
        driver.setAvailable(true);
    }
    public double calculateFare(){
        return baseFare+15.0*getDistance();
    }
    public String getSummary(){
        return String.format("Trip Summary\n"+"Passenger: %s\n"+
        "Driver: %s (%s)\n"+
                "From: %s\n"
                +"To: %s \n"
                +"Distance: %.2f km\n"+
                "Fare: BDT %.2f\n"
                +"Status: %s",
                passenger.getName(),driver.getname(),driver.getLicensePlate(),from.toString(),to.toString(),
                getDistance(),calculateFare(),completeTrip ?  "Completed" : "In Progress");
    }
}
