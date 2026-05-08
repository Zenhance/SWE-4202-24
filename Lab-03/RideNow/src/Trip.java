public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed=false;
    Trip(Passenger passenger,Driver driver,Location from,Location to,
         double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
        this.completed=false;
        this.driver.setAvailable(false);


    }
    public Passenger getPassenger(){
        return  passenger;
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
    public  double getBaseFare(){
        return baseFare;
    }

    public boolean isCompleted() {

        return completed;
    }
    public double getDistance(){
        double distance= from.distanceTo(to);
        return distance;


    }
    public double calculateFare(){
        double fare = baseFare+15.0*getDistance();
        return fare;
    }
    public void completeTrip(){
        this.completed=true;
        this.driver.setAvailable(true);
    }
    public String getSummary(){
        String condition;
        if(completed== true){
            condition="COMPLETED";
        }
        else{
            condition="IN PROGRESS";
        }
        return  "Trip Summary"+
                "Passenger :"+ passenger.getName()+
                "Driver    :"+ driver.getName()+" ("+driver.getLicencePlate()+")"+
                "From      :"+from.toString() +
                "To        :"+to.toString() +
                "Distance  :"+String.format( "%.2f", this.getDistance())+"km"+
                "Fare      :"+"BDT "+String.format("%.2f",this.calculateFare())+
                "Status    :"+ condition;
    }
}
