public class Trip {

    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;


    Trip(Passenger passenger, Driver driver, Location from,
         Location to, double baseFare){
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

    public boolean isCompleted() {
        return completed;
    }

    double distance = from.distanceTo(to.x, to.y);

    public double getDistance(){
        return distance;
    }

    double fare;
    public double calculateFare() {
        fare = baseFare + 15.0 * distance;
        return fare;
    }

    public void completeTrip(){
        driver.setAvailable(true);
    }

    public String getSummary(){
        String msg;
        if (completed  == true){
            msg = "COMPLETED";
        }
        else{
            msg =  "IN PROGRESS";
        }
        String res =
                "Trip Summary" +
                        "\n\tPassenger\t:\t" + passenger.getName()+
                        "\n\tDriver\t:\t" + driver.getName()+
                        "\n\tFrom\t:\t"+from.toString()+
                        "\n\tTo\t:\t"+to.toString()+
                        "\n\tDistance\t:\t"+distance+ " km"+
                        "\n\tFare\t:\t"+"BDT "+fare+
                        "\n\tStatus\t:\t"+msg;

        return res;
    }
}
