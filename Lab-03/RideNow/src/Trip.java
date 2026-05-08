public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed=false;

    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;
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
        double distance = from.distanceTo(to);
        return distance;
    }

    public double calculateFare() {
        double fare=baseFare + 15.0 * from.distanceTo(to);
        return fare;
    }

    public void completeTrip() {
        completed=true;
        driver.setAvailable(true);
    }

    public String getSummary(){
        String status;
        if(completed) {
            status = "COMPLETED";
        }
        else{status="IN PROGRESS";}

        return "Trip Summary\n" +
        "Passenger :" + passenger.getName() + "\n" +
                "Driver :" + driver.getName() + "(" + driver.getLicencePlate() + ")\n" +
                "From :" + from.getLabel() + "(" + from.getX() + "," + from.getY() + ")\n" +
                "To :" + to.getLabel() + "(" + to.getX() + "," + to.getY() + ")\n" +
                "Distance :" + String.format("%.2f",getDistance()) + " km" + "\n" +
                "Fare :" + String.format("BDT %.2f",calculateFare()) + "\n" +
                "Status :" + status;
    }
);
        );
    }
}
