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

public void getPassenger(){

    return passenger;
}

public void getDriver(){

    retrun driver;
}

public void getFrom(){

        retrun from;
    }

public void getTo(){

        retrun to;
    }


}
