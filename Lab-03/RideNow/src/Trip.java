public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
        completed=false;
        driver.setAvailable(false);


    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getFrom() {
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

    public double getDistance() {
        return from.distanceTo(to);
    }
    double fare;
    public double calculateFare(){
        double fare= baseFare + 15* from.distanceTo(to);
        return fare;
    }
    public void completeTrip(){
        this.completed = true;
        driver.setAvailable(true);
    }
    public String getSummary(){
        String stat;
        if (completed){
            stat="COMPLETED";
        }
        else {
            stat="IN PROGRESS";
        }
        String summary="Trip Summary"+
                "Passenger  :" +passenger.getName()+
                "Driver  :"+driver.toString()+
                "From  :"+from.toString()+
                "To  :"+to.toString()+
                "Distance  : "+String.format("%.2f",from.distanceTo(to))+"KM"+
                "Fare  :"+
                "BDT"+ fare+
                "Status  :"+stat;
        return summary;
    }

}
