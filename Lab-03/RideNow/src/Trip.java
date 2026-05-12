public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed=false;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
        this.completed=false;
        this.driver.setAvailable(false);
    }

    Passenger getPassenger(){
        return passenger;
    }
    Driver getDriver(){
        return driver;
    }
    Location getFrom(){
        return from;
    }
    Location getTo(){
        return to;
    }
    double getBaseFare(){
        return baseFare;
    }
    boolean isCompleted(){
        return completed;
    }

    double getDistance(){
        double distance= from.distanceTo(to);
        return distance;
    }
    double calculateFare(){
        return this.baseFare+ (15.0 * getDistance());
    }

    void completeTrip(){
        this.completed=true;
        this.driver.setAvailable(true);
    }

    String getSummary(){
        String res;
        if(completed==true){
            res="COMPLETED";
        }else{
            res="IN PROGRESS";
        }
        return String.format(
                "Passenger: %s\n"+
                        "Trip Summary\n"+
                        "Driver: %s (%s)\n"+
                        "From: %s\n"+
                        "To: %s\n"+
                        "Distance: %.2f Km\n"+
                        "Fare:BDT %.2f\n"+
                        "Status: %s",

                passenger.getName(),
                driver.getName(),
                driver.getLicencePlate(),
                from.toString(),
                to.toString(),
                getDistance(),
                calculateFare(),
                res
        );
    }
}
