public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;
    private double fare;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;
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

    public double getBaseFare() {
        return baseFare;
    }

    public boolean isCompleted() {
        return completed;
    }

    public double getDistance() {
        return from.distanceTo(to);
    }

    public double calculateFare() {
        fare = baseFare + 15 * getDistance();
        return fare;
    }

    public void completeTrip() {
        completed = true;
        driver.setAvailable(true);
    }

    public String getSummary() {
        String status;
        if (completed) {
            status = "COMPLETED";
        } else {
            status = "IN PROGRESS";
        }

        String sum = "Trip Summary" +
                "Passenger  :" + passenger.getName() +
                "Driver  :" + driver.getName() + " " + driver.getLicencePlate() +
                "From  :" + from.toString() +
                "To  :" + to.toString() +
                "Distance :" + getDistance() + "km" +
                "Fare :" + "BDT" + String.format("%.2f", fare) +
                "Status :" + status;

        return sum;


    }


}
