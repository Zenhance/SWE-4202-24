public class Trip {
    Passenger passenger;
 Driver driver;
 Location from;
 Location to;
 double baseFare;
 boolean completed=false;

 public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare){
     this.passenger=passenger;
     this.driver=driver;
     this.from=from;
     this.to=to;
     this.baseFare=baseFare;
 }
}
