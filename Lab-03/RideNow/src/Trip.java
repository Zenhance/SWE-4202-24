public class Trip {

    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare=100;
    private boolean completed=false;

    Trip(Passenger passenger,Driver driver,Location from,Location to,double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
        this.completed=false;
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
        return from.distanceTo(to);
    }

    public  double calculateFare(){
        double fare=baseFare+(getDistance()*15.0);
        return fare;
    }

    public void completeTrip(){
        completed=true;
        driver.setAvailable(true);
    }

    public String getSummary(){
        return "Trip Summary\n  Passenger : "+getPassenger().getName()+"\n  Driver    : "+getDriver().getName()+" ("+getDriver().getLicencePlate()+")\n"+"  From      : "+from.toString()+
                "\n  To        : "+to.toString()+"\n  Distance  : "+String.format("%.2f",getDistance())+" km\n  Fare      : BDT "+String.format("%.2f",calculateFare())+"\n"+"  Status    : "+(completed?"COMPLETED":"IN PROGRESS");
    }
}
