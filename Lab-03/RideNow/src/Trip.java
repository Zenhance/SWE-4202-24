public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed=false;

    Trip(Passenger passenger,Driver driver,Location from,Location to,double basefare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
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
    public boolean idCompleted(){
        return completed;
    }

    public  double getDistance(){
        return from.distance(to);
    }
    public double calculateFare(){
        return baseFare=baseFare+15.0*getDistance();
    }

     void completeTrip(){
        driver.setAvailable(true);
     }

     String getSummary(){
        String status;
        if(completed){status="Completed";}
        else{status="In progress";}
       return String.format("Trip Summary\n"+"Passenger :%s\n"+"Driver :%s (%s)\n"+"From : %s\n" +"To: %s\n"+"Distance : %.2f km\n" +"Fare : BDT %.2f km\n" +"Status : %s",passenger.getName(),driver.getName(),driver.getLicencePlate(),from.toString(),to.toString(),getDistance(),calculateFare(),status);
     }
}
