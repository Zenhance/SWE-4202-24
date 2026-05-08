public class Trip {
    private Passenger passsenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;
    public Trip(Passenger passenger, Driver driver, Location from, Location to,double baseFare){
        this.passenger=passenger;
        this.driver= driver;
        this.from=from;
        this.to= to;
        this.baseFare=baseFare;
        this.completed=false;
        this.driver.setAvailable(false);

    }
    public Passenger getPassenger(){return passenger;}
    public Driver getDriver(){return driver;}
    public Location getFrom(){return from;}
    public Location getTo(){return to;}
    public double getBaseFare(){return baseFare;}
    public boolean getCompleted(){return completed;}
    public double getDistance(){
        return from.distanceTo(to);
    }
    public double calculateFare(){
        return baseFare + (15*getDistance());
    }
    public void completeTrip(){
        this.completed=true;
        this.driver.setAvailable(true);}
    public String getSummary(){
        String status= completed? "COMPLETED": "IN PROGRESS";
        return String.format("Trip Summary\n"+ "Passenger : %s\n"+"Driver : %s (%s)\n"+"From : %s\n"+"To : %s\n"+
                "Distance : %.2f km\n"+ "Fare : BDT %.2f\n"+"Status : %s",
                passenger.getName(),driver.getName(),driver.getlicencePlate(),from.toString(),to.toString(),getDistance(),calculateFare()
                , status);
    }
}





}
