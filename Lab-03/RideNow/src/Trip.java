import jdk.jfr.TransitionFrom;

import java.util.TooManyListenersException;

public class Trip {
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

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

    public double getdistance() {
        return from.distanceTo(to);
    }

    public double calculatedFare() {
        return baseFare + 15.0 * getdistance();
    }

    public void completeTrip() {
        completed = true;
        driver.setAvailable(true);
    }

    public String getsummary() {
        String status = completed ? "COMPLETED" : "IN PROGRESS";
        return "Trip Summary/n" + "Passenger:" + passenger.getName() + "/n" + "Driver:" + driver.getName() + "(" + driver.getLicencePlate() + "/n" + from.toString() + "/n" + to.toString() + "/n" + "From:" + from.toString() + "/n" + "To" + to.toString() + "/n" + "Distance: " + String.format("%.2f", getdistance()) + "km\n" + "FareL:BDT" + String.format("%.2f", calculatedFare()) + "\n" + "Status:" + status;
    }
}
