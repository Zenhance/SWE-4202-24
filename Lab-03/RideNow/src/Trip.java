public class Trip {
    Passenger passenger;
    Driver driver;
    Location from;
    Location to;
    double baseFare;
    boolean completed;
    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
        this.completed=false;
        driver.setAvailable(false);
    }
    /// ///////////////////////////////
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
        return from.distanceTo(to);
    }
    /// /////////////////////////////////////
    public double calulateFare(){
        return baseFare+(15.0*getDistance());
    }
    public void completeTrip(){
        completed=true;
        driver.setAvailable(true);
    }
    ////////////////////////////////////////
    public String getSummary(){
        String current_status;
        if(completed==true){
            current_status="COMPLETED";
        }
        else current_status="IN PROGRESS";
        return String.format("Trip summary\nPassenger :\t%s\nDriver :\t%s (%s)\nFrom :\t%s (%.2f, %.2f)\nTo :\t%s (%.2f, %.2f)Distance :\t%.2f km\nFare :\tBDT %.2f\nStatus :\t%s",passenger.getName(),driver.getName(),driver.getLicencePlate(),from.toString(),to.toString(),getDistance(),calulateFare(),current_status);
    }
}
