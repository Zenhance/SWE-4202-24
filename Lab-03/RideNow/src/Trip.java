public class Trip {
    Passenger passenger;
    Driver driver;
    Location from;
    Location to;
    double baseFare; //a fixed per-trip charge in BDT.
    boolean completed;
    
    Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;
        
        driver.setAvailable(false);
    }
    
    Passenger getPassenger() {
        return this.passenger;
    }
    
    Driver getDriver() {
        return this.driver;
    }
    
    Location getFrom() {
        return this.from;
    }
    
    Location getTo() {
        return this.to;
    }
    
    double getBaseFare() {
        return this.baseFare;
    }
    
    boolean isCompleted() {
        return this.completed;
    }
    
    double getDistance() {
        return from.distanceTo(this.to);
    }
    
    double calculateFare() {
        return baseFare + 15.0 * getDistance();
    }
    
    void completeTrip() {
        this.completed = true;
        driver.setAvailable(true);
    }
    
    String getSummary() {
        return String.format("Trip Summary\n Passenger: %s\n Driver: %s (%s)\n From: %s\n To: %s\n Distance: %.2f km\n Fare: BDT %.2f\n Status: %s\n",
                passenger.getName(),
                driver.getName(),
                driver.getLicencePlate(),
                from.toString(),
                to.toString(),
                getDistance(),
                calculateFare(),
                completed ? "COMPLETED" : "IN PROGRESS");
    }
}
