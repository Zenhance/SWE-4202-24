public class Trip {

          private Passenger passenger;
          private Driver driver;
          private Location from;
          private Location to;
          private double baseFare=10;
          private boolean completed=false;



public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){

    this.passenger=passenger;
    this.driver=driver;
    this.from=from;
    this.to=to;
    this.baseFare=baseFare;
    completed=false;
    driver.setAvailable(false);
}

public Passenger getPassenger(){

    return passenger;
}

public Driver getDriver(){

    retrun driver;
}

public Location getFrom(){

        retrun from;
    }

public Location getTo(){

        retrun to;
    }

public double getBaseFare(){
    return baseFare;
}


public boolean isCompleted(){
        return completed;
    }







}
