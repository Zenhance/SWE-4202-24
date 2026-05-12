public class Trip {

    //fields
    private Passenger passenger;
    private Driver driver;

    private Location from;
    private Location to;

    private double baseFare;
    private boolean completed = false;


    //constructor
    public Trip(Passenger passenger, Driver driver, Location from, Location to, double
            baseFare) {

        //storing five arguments
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;

        completed = false;

        driver.setAvailable = false;


        //methods

        //getters
        public void getPassenger(){

        }

        public void getDriver(){

        }

        public void




    }
}