public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare = 50;
    private boolean completed = false;


    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        completed = false;
        driver.setAvailable(false);
    }

    public Passenger getPassenger() {
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
    public boolean isCompleted() {
        return completed;
    }

    public double getDistance(){
        return from.distanceTo(to);
    }

    double fare;
    public double calculateFare() {
        fare = baseFare + 15.0 * from.distanceTo(to);
        return fare;
    }

    public void completeTrip(){
        completed = true;
        driver.setAvailable(true);
    }

    public String getSummary(){
        String msg;
        if (completed == true){
            msg = "COMPLETED";
        }
        else{
            msg =  "IN PROGRESS";
        }
        String res =
                "Trip Summary" +
                        "\n\tPassenger\t:\t" + passenger.getName()+
                        "\n\tDriver\t:\t" + driver.toString()+
                        "\n\tFrom\t:\t"+from.toString()+
                        "\n\tTo\t:\t"+to.toString()+
                        "\n\tDistance\t:\t"+String.format("%.2f", from.distanceTo(to))+ " km"+
                        "\n\tFare\t:\t"+"BDT "+fare+
                        "\n\tStatus\t:\t"+msg;

        return res;
    }
}
