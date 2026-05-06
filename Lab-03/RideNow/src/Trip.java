public class Trip {
    private final Passenger passenger;
    private final Driver driver;
    private final Location from;
    private final Location to;
    private final double baseFare;
    private boolean completed;

    Trip(Passenger passenger,Driver driver,Location from,Location to,double basefare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=basefare;
        completed=false;
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
    public Location getTo() {
        return to;
    }
        public double getBaseFare(){
            return baseFare;
        }
    public boolean isCompleted(){
        return completed;
    }

    public  double getDistance(){
        return from.distanceTo(to);
    }
    public double calculateFare(){
        return baseFare+15.0* getDistance();
    }

     void completeTrip(){
        completed=true;
        driver.setAvailable(true);
     }

     String getSummary(){
        String status;
        if(completed){status="COMPLETED";}
        else{status="IN PROGRESS";}
       return String.format("Trip Summary\n" +"Passenger :%s\n"+"Driver :%s (%s)\n"+"From : %s\n" +"To: %s\n"+"Distance : %.2f km\n" +"Fare : BDT %.2f km\n" +"Status : %s",passenger.getName(),driver.getName(),driver.getLicencePlate(),from.toString(),to.toString(),getDistance(),calculateFare(),status);
     }
}
