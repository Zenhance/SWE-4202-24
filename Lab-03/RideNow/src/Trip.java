/* 
fixed capitalizations, a single missing curly brace fix automatically reduced 37 errors, fixed setAvailble, previously 
my syntax treated it as a variable whereas it is a method, made some correction to the final print statement, fixed status




*/
public class Trip
{
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;
    public Trip (Passenger passenger, Driver driver, Location from, Location to, double baseFare) {
        this.passenger = passenger;
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.baseFare = baseFare;
        this.completed = false;
        driver.setAvailable (false); //driver variable inside trip class calls the setAvailable method that we defined inside driver and sets it to false
    }

        public Passenger getPassenger()
        {  return this.passenger;
        }
        public Driver getDriver()
        {
            return this.driver;
        }
        public Location getFrom()
        {
            return from;
        }
        public Location getTo()
        {
            return to;
        }
        public double getBaseFare()
        {
            return baseFare;
        }
        public boolean isCompleted()
        {
            return completed;
        }
        public double getDistance()
        {
         return   from.distanceTo(to);
 /*
 here, we are calling the distanceTo method that we defined inside location class
 to calculate the distance between from and to, here according to our syntax, from is the caller object and
 to is being passed as the argument, so "this" keyword inside distanceTo keyword uses the value returned by from and "other"
uses the value returned by to
 */       }
        public double calculateFare()
        {
            return baseFare + (15*getDistance());
        }
        public void completeTrip()
        {
            this.completed=true;
            driver.setAvailable(true);

        }
        public String getSummary()
        { String status;

            if (completed) {
                status = "COMPLETED";
            } else {
                status = "IN PROGRESS";
            }

            return "Trip Summary\n"
                    + "Passenger : " + passenger.getName() + "\n"
                    + "Driver    :" + driver.getName() + "(" + driver.getLicensePlate()+ " )\n"
                + "From      : " + from.toString() + " \n"
                + "To        :  " + to.toString() + "\n"
                + "Distance  : " + String.format("%.2f", getDistance()) + " km \n"
                +" Fare      :BDT " + String.format(" %.2f", calculateFare() ) + " \n"
                + "Status    :" +status;
        }
    }






